package net.leloubil.pronotelib.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.leloubil.pronotelib.PronoteConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatiereListDeser extends JsonDeserializer<List<Matiere>> {


    public MatiereListDeser() {
    }

    @Override
    public List<Matiere> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper om = new ObjectMapper();
        //om.registerModule(co.deserModule);

        om.registerModule(PronoteConnection.staticModule);
        ArrayList<Matiere> temp = new ArrayList<>();
        JsonNode node = (JsonNode) p.getCodec().readTree(p).get("V");
        node.forEach(c -> {
            try {
                temp.add(om.treeToValue(c, Matiere.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return temp;
    }
}
