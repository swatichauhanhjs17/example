(ns trial.events
  (:require
   [re-frame.core :as re-frame]
   [trial.db :as db]
   [reagent.core :as r]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))



(re-frame/reg-event-db
  :submit
  (fn [db[_ final]]
    (def my-var final )
      ( assoc db :result  my-var ))
  )
