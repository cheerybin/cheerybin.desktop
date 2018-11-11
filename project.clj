(defproject cheerybin-desktop "0.0.1"
  :description "front end framework for Chat Apps"
  :url "https://github.com/cheerybin/cheerybin.desktop"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["build/"]

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.1.9"]]
                   :cljsbuild
                    {:builds
                     [{:source-paths ["src/cb"]
                       ; :figwheel     {:on-jsload ""}
                       :compiler     {:output-to      "build/main.js"
                                      :optimizations  :none
                                      :main           cb.core
                                      :install-deps   true
                                      :target         :nodejs
                                      :parallel-build true
                                      :source-map     true
                                      :pretty-print   true}}]}}

             :prod {:cljsbuild
                    {:builds
                      [{:source-paths ["src/cb"]
                        :compiler     {:output-to      "build/main.js"
                                       :optimizations  :advanced
                                       :main           app.main.core
                                       :install-deps   true
                                       :target         :nodejs
                                       :parallel-build true
                                       :process-shim   true
                                       :pretty-print   false
                                       :elide-asserts  true}}]}}}
  :aliases {"fig"   ["trampoline" "run" "-m" "figwheel.main"]
            "build" ["trampoline" "run" "-m" "figwheel.main" "-b" "cb"]})
