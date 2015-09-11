yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title(pageTitle)
        link(rel: 'stylesheet', href: '/css/bootstrap.min.css')
    }
    body {
        div(class: 'container') {
            div(class: 'navbar') {
                div(class: 'navbar-inner') {
                    a(class: 'brand',
                            href: 'http://www.springone2gx.com/',
                            'SpringOne2GX')
                }
            }
            mainBody()
        }
    }
}
