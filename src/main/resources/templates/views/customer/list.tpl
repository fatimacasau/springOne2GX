layout 'layouts/main.tpl',
        pageTitle: 'List customers',
        mainBody: contents {
            ul {
                customers.each { customer ->
                    li {
                        p("$customer.firstName $customer.lastName ")
                    }
                }
            }
            div{
                a(href:"/", "Go to home")
            }
        }
