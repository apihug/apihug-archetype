package config

import static hope.kola.contract.Configuration.*

var port = 9527

[
        common {
            p("date", ofDate("2022-12-12"))
            rest {
                closeIdleConnectionsAfterEachResponse()
                log {
                    enablePrettyPrinting()
                    logAllDetailIfValidationFails()
                }
                client {
                    connectTimeoutInSeconds(3)
                }
            }

        },

        env("dev", {

            baseURI("https://dev.example.com")
            port(port)

        })
        //TODO Other env definitions
]