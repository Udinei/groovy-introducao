package classes

import groovy.xml.MarkupBuilder

    def sb = new StringWriter()
    def html = new MarkupBuilder(sb)

    html.doubleQuotes = true
    html.expandEmptyElements = true
    html.omitEmptyAttributes = false
    html.omitNullAttributes = false
    html.html {
        head {
            title ('Heading')
            script (src: 'test.js', type: 'text/javascript')
        }
        body {
            mkp.yieldUnescaped('<!--')
            mkp.yield('<test>')
            mkp.yieldUnescaped('-->')

            ul {
                for (def i=0;i<10;i++) {
                    li (i)
                }
            }
        }
    }

    println sb.toString()

