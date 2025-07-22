# Clojure Boilerplate

## Setup

- Install [Leiningen](https://leiningen.org/)
- Install [Clojure](https://clojure.org/guides/getting_started)
- Install [Clojure-lsp](https://clojure-lsp.github.io/clojure-lsp/installation/)
- ...

## Libraries

### Core

- https://leiningen.org/
  - https://github.com/technomancy/leiningen?tab=readme-ov-file (mirror)

### Http

- https://github.com/pedestal/pedestal
- https://github.com/plumatic/schema

### Testing

- https://github.com/nubank/state-flow

### Database

- [Datomic](https://github.com/omariosouto/nunos-study/tree/7b3f9c6fff7efa11fa83aac3e194455e5e8b4035/101/database)

## Running Tests

This project uses [state-flow](https://github.com/nubank/state-flow) for stateful testing.

To run tests:

```bash
lein with-profile test test
```

Make sure your tests are in the `test/` directory.

# References

- https://pedestal.io/pedestal/0.6/guides/your-first-api.html
- https://github.com/pelichero/code4nimbus/tree/main
- https://github.com/pelichero/code4nimbus/tree/main/clojure-api
- https://medium.com/@felipepelichero/dependency-injection-with-clojure-6ee5dc839c08

## IDE Setup

```json
{
  "calva.replConnectSequences": [
    {
      "name": "✨ Lein REPL",
      "projectType": "Leiningen",
      "autoSelectForJackIn": false,
      "menuSelections": {
        "leinAlias": null,
        "leinProfiles": []
      }
    }
  ],
  "calva.outputDestinations": {
    "evalResults": "terminal",
    "evalOutput": "terminal",
    "otherOutput": "terminal"
  }
}
```
```
# keybindings.json
```