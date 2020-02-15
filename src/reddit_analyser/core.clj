(ns reddit-analyser.core
  (:require [clj-http.client :as client])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (client/get "http://www.example.com/")))

(client/get "http://www.example.com/")
