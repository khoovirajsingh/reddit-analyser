(ns reddit-analyser.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def options {:headers {"User-agent" "bond-007"}})
(def url "https://www.reddit.com/r/Clojure.json")
(client/get url options)
