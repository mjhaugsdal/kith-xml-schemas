package io.github.mjhaugsdal;

import org.apache.cxf.common.xmlschema.LSInputImpl;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class SchemaResolvingUtils {

    static Schema resolveSchemas(SchemaFactory schemaFactory) {
        schemaFactory.setResourceResolver((type, namespaceURI, publicId, systemId, baseURI) -> {
            String basePath = "skjema/eresept/";
            String resolvedPath = basePath + systemId;

            //Ugly workarounds
            if (resolvedPath.contains("XMLSchema.dtd")) {
                resolvedPath = basePath + "XMLSchema.dtd";
            }
            if (resolvedPath.contains("xml.xsd")) {
                resolvedPath = basePath + "xml.xsd";
            }
            InputStream is = JaxbUtils.class.getClassLoader().getResourceAsStream(resolvedPath);


            if (is == null) {
                throw new IllegalArgumentException("Could not find XSD: " + resolvedPath);
            }

            LSInputImpl input = new LSInputImpl(publicId, systemId, is);
            input.setBaseURI(baseURI);
            return input;
        });
        try {
            Path resourcesDir = Paths.get("src/test/resources").toAbsolutePath().normalize();
            List<StreamSource> sources = Files.walk(resourcesDir.resolve("skjema/eresept"))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".xsd"))
                    .map(path -> resourcesDir.relativize(path).toString().replace("\\", "/")) // normalize for classpath
                    .map(relPath -> new StreamSource(
                            Objects.requireNonNull(
                                    JaxbUtils.class.getClassLoader().getResourceAsStream(relPath),
                                    "Missing resource: " + relPath
                            )
                    ))
                    .toList();

            Source[] schemaArray = sources.toArray(new Source[0]);
            return schemaFactory.newSchema(schemaArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
