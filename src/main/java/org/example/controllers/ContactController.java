package org.example.controllers;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;
import io.javalin.http.NotFoundResponse;
import org.example.domain.Contact;

import java.util.Optional;

public class ContactController {

    public static Handler create = ctx -> {
        Contact request = ctx.bodyAsClass(Contact.class);
        request.setId(Contact.find.all().size() + 1L);
        request.save();
        ctx.status(HttpCode.CREATED);
        ctx.json(request);
    };

    public static void getAll(Context ctx) {
        ctx.json(Contact.find.all());
    }

    private static Long getId(Context ctx) {
        return Optional.ofNullable(ctx.pathParamAsClass("id", Long.class).getOrDefault(null))
                .orElseThrow(NotFoundResponse::new);
    }

    public static void getById(Context ctx) {
        Long id = getId(ctx);
        Contact contact = Contact.find.byId(id);

        if (contact != null) {
            ctx.json(contact);
        } else {
            ctx.status(HttpCode.NOT_FOUND);
        }

    }
}
