(defproject boilerplate-clojure "0.1.0-SNAPSHOT"
  :description "A Pedestal Clojure boilerplate project."
  :url "https://github.com/omariosouto/boilerplate-clojure" 
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.12.1"]
                 [cheshire "5.10.0"]
                 [nubank/state-flow "5.20.1"]
                 [io.pedestal/pedestal.jetty "0.7.0"]
                 [org.clojure/data.json "2.4.0"]
                 [org.slf4j/slf4j-simple "2.0.17"]]
  :source-paths ["src"]
  :main boilerplate-clojure.server
  
  :test-paths ["test/"]) 