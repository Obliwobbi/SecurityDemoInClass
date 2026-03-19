package dk.ek.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dk.bugelhartmann.UserDTO;
import dk.ek.persistence.HibernateConfig;
import dk.ek.persistence.ISecurityDAO;
import dk.ek.persistence.SecurityDAO;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;


public class SecurityController implements ISecurityController{
    ISecurityDAO securityDAO = new SecurityDAO(HibernateConfig.getEntityManagerFactory());
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void register(Context ctx) {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);
        securityDAO.createUser(user.getUsername(), user.getPassword());
        ObjectNode node = objectMapper.createObjectNode();
        node.put("msg","login register succesfull");
        ctx.json(node).status(201);
    }

    @Override
    public void login(Context ctx) {
    }

    @Override
    public void authenticate(Context ctx) {

    }

    @Override
    public void authorize(Context ctx) {

    }
}
