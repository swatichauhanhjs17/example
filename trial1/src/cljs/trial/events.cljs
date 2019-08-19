(ns trial.events
  (:require
   [re-frame.core :as re-frame]
   [trial.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))



(re-frame/reg-event-db
       :event1
       (fn [db [_ final]]
        (assoc db :final(str (get final :identity)))))


(re-frame/reg-event-db
  :event1
  (fn [db [_ final]]
    (assoc db :final(str (get final :identity)))))


(re-frame/reg-event-db
    :submit
    (fn [db _]
      ( assoc db :result "Form submitted")))
