(ns trial.views
  (:require
    [re-frame.core :as re-frame]
    [trial.subs :as subs]
    [reagent.core :as r]))

(defn my-country
  [final] [:input
           {:type      "text"
            :value     (get @final :country)
            :on-change #(swap! final assoc :country (-> % .-target .-value))}])

(defn my-identity
  [final] [:input
           {:type      "text"
            :value     (get @final :identity)
            :on-change #(swap! final assoc :identity (-> % .-target .-value))}])

(defn my-form
  []
  (let [final (r/atom {:identity "  NAME"
                       :country  " country"})]
    (fn []
      [:div
       [:h3 [:span {:style {:color "red"}} "Enter your name :- " [my-identity final]]]
       [:h2 [:span {:style {:color "blue"}} "Enter your country :- " [my-country final]]]
       [:input {:type     "button"
                :value    "submit"
                :on-click #(re-frame/dispatch [:submit @final])}]])))












(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        all-values (re-frame/subscribe [::subs/all-values])
        last-submitted (re-frame/subscribe [::subs/last-submitted])
        ]


    [:div [:h1 "Hello from " @name]


     [my-form]
      [:p "Recent Info" @last-submitted]
     [:ol (for [item @all-values]
            ^{:key (str item)} [:li "DATA OF THE FORM :- " (str item)])
      ]

     ]

    ))
