(ns test.events
  (:require
   [re-frame.core :as re-frame]
   [test.db :as db]
   ))


 (re-frame/reg-event-db
  :identity
  (fn [db [_ value age address]]
    (assoc db :final(str value age address))))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
