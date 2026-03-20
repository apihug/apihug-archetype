import hope.kola.contract.Feature

Feature.make {

    priority 100
    name("Very import feature")
    description("""This feature is critical""")
    //enable("qa", "dev")
    disable("prod")

    Scenario "Template ExamplePost Demo", {
        Given {
            api("TemplateExampleService", "ExamplePost")
        }
        When {
            json """
            {
              "name": "apihug",
              "email": "a@b.com"
            }
            """
            body {
                set("name", "Hello ApiHug!")
            }
        }
        And {
            isOk()
        }
    }

    Scenario "Just Call Github ", {
        Given {
            get("https://github.com")
        }
        And {
            isOk()
        }
    }

}