(ns boilerplate-clojure.server
  (:require
    [boilerplate-clojure.components :as components]))

;; (defn start []
;;   (http/start (http/create-server service-map)))

;; For interactive development
;; (defonce server (atom nil))

;; (defn start-dev []
;;   (reset! server
;;           (http/start (http/create-server
;;                        (assoc service-map
;;                               ::http/join? false)))))

;; (defn stop-dev []
;;   (http/stop @server))

;; (defn restart []
;;   (stop-dev)
;;   (start-dev))

;; (def -main            (partial embedded-servlet/main                       components/create-and-start-system!))
;; (def run-dev          (partial embedded-servlet/main                       components/create-and-start-system!))
;; (def servlet-init     (partial container-servlet/servlet-init              components/create-and-start-system!))
;; (def servlet-destroy  (partial container-servlet/servlet-destroy           components/create-and-start-system!))
;; (def servlet-service  container-servlet/servlet-service)

; TODO: https://pedestal.io/pedestal/0.6/guides/pedestal-with-component.html
(def -main (partial components/create-and-start-system!))