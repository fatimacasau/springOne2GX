layout 'layouts/main.tpl',
        pageTitle: "SpringOne2GX - Use Groovy in your Spring Boot applications, don't be afraid",
        mainBody: contents {
            div("This is an application using Boot $bootVersion and Groovy templates $groovyVersion")
            div{
                a(href:"/customers", "List Customers")
            }
        }
