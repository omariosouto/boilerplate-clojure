(defproject boilerplate-clojure "0.1.0-SNAPSHOT"
  :description "A Pedestal Clojure boilerplate project."
  :url "http://example.com/boilerplate-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [org.clojure/tools.namespace "1.4.4"]]
  :source-paths ["src"]
  :main boilerplate-clojure.server
  :profiles {:dev {:dependencies []}
             :prod {:aot :all
                    :uberjar-name "boilerplate-clojure-standalone.jar"}}) 