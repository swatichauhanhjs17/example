(ns trial.views
  (:require
   [re-frame.core :as re-frame]
   [trial.subs :as subs]
   [reagent.core :as r]))


(defn my-country
     [final] [:input
               { :type "text"
                 :value (get @final :country)
                 :on-change #(reset! final(-> % .-target .-value))}])

(defn my-identity
    [final] [:input
             {:type      "text"
              :value     (get @final :identity)
              :on-change #(reset! final(-> % .-target .-value))}])

(defn my-form
  []
  (let [final (r/atom {:identity "  NAME"
                        :country " country"})]
      (fn []
          [:div
            [:h3 [:span {:style {:color "red"}} "Enter you name :- " [my-identity final]]]
            [:h2 [:span {:style {:color "blue"}} "Enter you country :- " [my-country final]]]
            [:input {:type "button"
                     :value "submit"
                     :on-click #(re-frame/dispatch [:submit])}]])))














(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        con (re-frame/subscribe [::subs/result])]

    [:div
     [:h1 "Hello from " @name]

     [:p "THIS IS A FORM"]
     [ my-form]
     [:p "" @con]]))
