(defproject org-cms "0.1.0-SNAPSHOT"
  :description "Static site generator with a special focus on org-mode and meta-tags."
  :url "https://github.com/timotheosh/org-cms"
  :license {:name "MIT"
            :url "https://opensource.org/license/mit/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.10.844"]
                 [ring-server "0.5.0"]
                 [ring "1.9.5"]
                 [ring/ring-defaults "0.3.3"]
                 [stasis "2023.06.03"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-environ "1.1.0"]
            [lein-cljsbuild "1.1.8"]]
  :main ^:skip-aot org-cms.core
  :target-path "target/%s"
  :source-paths ["src/clj"]
  :cljsbuild {:builds
              [{:id "dev",
                :source-paths ["src/cljs"],
                :compiler
                {:output-to "resources/public/js/main.js",
                 :output-dir "target/js/compiled/out",
                 :optimizations :simple,
                 :pretty-print true}}
               {:id "bundle",
                :source-paths ["target/js/compiled/out"],
                :compiler
                {:output-to "resources/public/js/bundled.js",
                 :optimizations :whitespace,
                 :pretty-print true}}]}
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
