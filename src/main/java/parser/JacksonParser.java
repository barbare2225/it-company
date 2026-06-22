package parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.solvd.itcompany.company.ITCompany;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class JacksonParser implements Parser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public ITCompany parse(File file) {
        ITCompany company = null;
        try {
            company = MAPPER.readValue(file, ITCompany.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;
    }

    public static class LocalDateDeserializer extends StdDeserializer<LocalDate> {

        public LocalDateDeserializer() {
            super(LocalDate.class);
        }

        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            String strDate = node.asText();
            return LocalDate.parse(strDate);
        }
    }
}