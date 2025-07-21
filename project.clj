(defproject boilerplate-clojure "0.1.0-SNAPSHOT"
  :description "A Pedestal Clojure boilerplate project."
  :url "http://example.com/boilerplate-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.1"]
                 [io.pedestal/pedestal.service "0.7.0"]
                 [io.pedestal/pedestal.jetty "0.7.0"]
                 [org.clojure/tools.namespace "1.5.0"]
                 [nubank/state-flow "5.20.1"]
                 [nubank/matcher-combinators "3.8.6"]
                 [org.slf4j/slf4j-simple "2.0.17"]]
  :source-paths ["src"]
  :main boilerplate-clojure.dev
  :profiles {:dev {:dependencies []}
             :prod {:aot [boilerplate-clojure.prod]}
             :test {:test-paths ["test"]}}) 