(ns trial.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [trial.events :as events]
   [trial.views :as views]
   [trial.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/music-component]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
