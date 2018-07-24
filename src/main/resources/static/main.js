(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {

    /***/ "./src/$$_lazy_route_resource lazy recursive":
    /*!**********************************************************!*\
      !*** ./src/$$_lazy_route_resource lazy namespace object ***!
      \**********************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        function webpackEmptyAsyncContext(req) {
            // Here Promise.resolve().then() is used instead of new Promise() to prevent
            // uncaught exception popping up in devtools
            return Promise.resolve().then(function () {
                var e = new Error('Cannot find module "' + req + '".');
                e.code = 'MODULE_NOT_FOUND';
                throw e;
            });
        }

        webpackEmptyAsyncContext.keys = function () {
            return [];
        };
        webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
        module.exports = webpackEmptyAsyncContext;
        webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

        /***/
    }),

    /***/ "./src/app/app.component.html":
    /*!************************************!*\
      !*** ./src/app/app.component.html ***!
      \************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<div>\n  <app-story></app-story>\n</div>\n"

        /***/
    }),

    /***/ "./src/app/app.component.ts":
    /*!**********************************!*\
      !*** ./src/app/app.component.ts ***!
      \**********************************/
    /*! exports provided: AppComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
            return AppComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };

        var AppComponent = /** @class */ (function () {
            function AppComponent() {
            }

            AppComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-root',
                    template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html")
                })
            ], AppComponent);
            return AppComponent;
        }());


        /***/
    }),

    /***/ "./src/app/app.module.ts":
    /*!*******************************!*\
      !*** ./src/app/app.module.ts ***!
      \*******************************/
    /*! exports provided: AppModule */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AppModule", function () {
            return AppModule;
        });
        /* harmony import */
        var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        /* harmony import */
        var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
        /* harmony import */
        var _story_story_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./story/story.component */ "./src/app/story/story.component.ts");
        /* harmony import */
        var _story_candidates_candidates_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./story/candidates/candidates.component */ "./src/app/story/candidates/candidates.component.ts");
        /* harmony import */
        var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "./node_modules/@fortawesome/angular-fontawesome/fesm5/angular-fontawesome.js");
        /* harmony import */
        var _story_add_candidate_add_candidate_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./story/add-candidate/add-candidate.component */ "./src/app/story/add-candidate/add-candidate.component.ts");
        /* harmony import */
        var _story_story_display_story_display_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./story/story-display/story-display.component */ "./src/app/story/story-display/story-display.component.ts");
        /* harmony import */
        var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
        /* harmony import */
        var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/@stomp/ng2-stompjs.es5.js");
        /* harmony import */
        var _config_stompConfig__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./config/stompConfig */ "./src/app/config/stompConfig.ts");
        /* harmony import */
        var _services_story_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./services/story.service */ "./src/app/services/story.service.ts");
        /* harmony import */
        var _angular_common_http__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
        /* harmony import */
        var _story_story_display_countdown_timer_countdown_timer_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./story/story-display/countdown-timer/countdown-timer.component */ "./src/app/story/story-display/countdown-timer/countdown-timer.component.ts");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };


        var AppModule = /** @class */ (function () {
            function AppModule() {
            }

            AppModule = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
                    declarations: [
                        _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                        _story_story_component__WEBPACK_IMPORTED_MODULE_3__["StoryComponent"],
                        _story_candidates_candidates_component__WEBPACK_IMPORTED_MODULE_4__["CandidatesComponent"],
                        _story_add_candidate_add_candidate_component__WEBPACK_IMPORTED_MODULE_6__["AddCandidateComponent"],
                        _story_story_display_story_display_component__WEBPACK_IMPORTED_MODULE_7__["StoryDisplayComponent"],
                        _story_story_display_countdown_timer_countdown_timer_component__WEBPACK_IMPORTED_MODULE_13__["CountdownTimerComponent"]
                    ],
                    imports: [
                        _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                        _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_5__["FontAwesomeModule"],
                        _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormsModule"],
                        _angular_common_http__WEBPACK_IMPORTED_MODULE_12__["HttpClientModule"]
                    ],
                    providers: [_services_story_service__WEBPACK_IMPORTED_MODULE_11__["StoryService"],
                        _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_9__["StompService"],
                        {
                            provide: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_9__["StompConfig"],
                            useValue: _config_stompConfig__WEBPACK_IMPORTED_MODULE_10__["stompConfig"]
                        }
                    ],
                    bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
                })
            ], AppModule);
            return AppModule;
        }());


        /***/
    }),

    /***/ "./src/app/config/stompConfig.ts":
    /*!***************************************!*\
      !*** ./src/app/config/stompConfig.ts ***!
      \***************************************/
    /*! exports provided: stompConfig */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "stompConfig", function () {
            return stompConfig;
        });
        var stompConfig = {
            // Which server?
            url: 'ws://18.211.206.82/socket/websocket',
            // Headers
            // Typical keys: login, passcode, host
            headers: {
                login: 'guest',
                passcode: 'guest'
            },
            // How often to heartbeat?
            // Interval in milliseconds, set to 0 to disable
            heartbeat_in: 0,
            heartbeat_out: 20000,
            // Wait in milliseconds before attempting auto reconnect
            // Set to 0 to disable
            // Typical value 5000 (5 seconds)
            reconnect_delay: 5000,
            // Will log diagnostics on console
            debug: true
        };


        /***/
    }),

    /***/ "./src/app/models/vote.ts":
    /*!********************************!*\
      !*** ./src/app/models/vote.ts ***!
      \********************************/
    /*! exports provided: Vote */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "Vote", function () {
            return Vote;
        });
        var Vote = /** @class */ (function () {
            function Vote(phrase, weightPolarity) {
                this.weight = 1;
                this.phrase = phrase;
                this.weightPolarity = weightPolarity;
            }

            return Vote;
        }());


        /***/
    }),

    /***/ "./src/app/services/story.service.ts":
    /*!*******************************************!*\
      !*** ./src/app/services/story.service.ts ***!
      \*******************************************/
    /*! exports provided: StoryService */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "StoryService", function () {
            return StoryService;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        /* harmony import */
        var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
        /* harmony import */
        var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
        /* harmony import */
        var rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/internal/observable/throwError */ "./node_modules/rxjs/internal/observable/throwError.js");
        /* harmony import */
        var rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3__);
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };


        var StoryService = /** @class */ (function () {
            function StoryService(http) {
                this.http = http;
                this.url = 'http://18.211.206.82/api/';
            }

            StoryService.prototype.getStory = function () {
                return this.http.get(this.url + 'story')
                    .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (data) {
                        return console.log('Single: ' + JSON.stringify(data));
                    }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(this.handleError));
            };
            StoryService.prototype.addWord = function (word) {
                this.http.post(this.url + 'add', word)
                    .subscribe(function (resp) {
                        console.log("response %o, ", resp);
                    });
            };
            StoryService.prototype.vote = function (vote) {
                var options = {
                    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                        'Content-Type': 'application/json'
                    })
                };
                var object = JSON.stringify(vote);
                this.http.post(this.url + 'vote', object, options)
                    .subscribe(function (resp) {
                        console.log("response %o, ", resp);
                    });
            };
            StoryService.prototype.handleError = function (err) {
                console.log(err.message);
                return Object(rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3__["throwError"])(err);
            };
            StoryService = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
                    providedIn: 'root'
                }),
                __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
            ], StoryService);
            return StoryService;
        }());


        /***/
    }),

    /***/ "./src/app/story/add-candidate/add-candidate.component.html":
    /*!******************************************************************!*\
      !*** ./src/app/story/add-candidate/add-candidate.component.html ***!
      \******************************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<div class=\"container text-light\">\n  <h2>Or add a new one</h2>\n  <label class=\"control-label sr-only\" for=\"phrase\">Enter phrase</label>\n  <div class=\"input-group\">\n    <input class=\"form-control\" id=\"phrase\" type=\"text\" placeholder=\"Enter your phrase here\"\n           [(ngModel)]=\"phrase\" (keyup)=\"onType()\">\n    <div class=\"input-group-append\">\n      <span class=\"input-group-text\">satoshi: {{cost}}</span>\n    </div>\n    <div class=\"input-group-append\">\n    <input class=\"btn btn-success\" type=\"submit\" value=\"add\"\n    (click)=\"onClick()\">\n    </div>\n  </div>\n</div>\n"

        /***/
    }),

    /***/ "./src/app/story/add-candidate/add-candidate.component.ts":
    /*!****************************************************************!*\
      !*** ./src/app/story/add-candidate/add-candidate.component.ts ***!
      \****************************************************************/
    /*! exports provided: AddCandidateComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AddCandidateComponent", function () {
            return AddCandidateComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };

        var AddCandidateComponent = /** @class */ (function () {
            function AddCandidateComponent() {
                this.cost = 0;
                this.phraseChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
                this.buttonClicked = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
            }

            AddCandidateComponent.prototype.ngOnInit = function () {
            };
            AddCandidateComponent.prototype.onType = function () {
                this.phraseChanged.emit(this.phrase);
                this.cost = this.fib(this.phrase.length);
            };
            AddCandidateComponent.prototype.onClick = function () {
                this.buttonClicked.emit(this.phrase);
                this.phrase = null;
                this.cost = 0;
            };
            AddCandidateComponent.prototype.fib = function (n) {
                var f = [];
                var i;
                f[0] = 0;
                f[1] = 1 / 50;
                for (i = 2; i <= n; i++) {
                    f[i] = f[i - 1] + f[i - 2];
                }
                return Math.ceil(f[n]);
            };
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
                __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"])
            ], AddCandidateComponent.prototype, "phraseChanged", void 0);
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
                __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"])
            ], AddCandidateComponent.prototype, "buttonClicked", void 0);
            AddCandidateComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-add-candidate',
                    template: __webpack_require__(/*! ./add-candidate.component.html */ "./src/app/story/add-candidate/add-candidate.component.html")
                }),
                __metadata("design:paramtypes", [])
            ], AddCandidateComponent);
            return AddCandidateComponent;
        }());


        /***/
    }),

    /***/ "./src/app/story/candidates/candidates.component.html":
    /*!************************************************************!*\
      !*** ./src/app/story/candidates/candidates.component.html ***!
      \************************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<div class=\"container mb-5\">\n  <h2 class=\"text-light\">{{candidatesTitle}}</h2>\n  <div *ngIf=\"!isVoting\">\n    <div *ngIf=\"!candidates || !candidates.length\">\n      <p class=\"text-muted\">{{candidatesEmptyMessage}}</p>\n    </div>\n    <div class=\"form-row\">\n      <div class=\"col-auto\"\n           *ngFor=\"let candidate of candidates\">\n        <div class=\"input-group mb-2\">\n          <div class=\"input-group-prepend\">\n            <button type=\"submit\" class=\"btn btn-success\" (click)=\"chooseCantidate(candidate.word, 1)\">\n              <fa-icon [icon]=\"faAngleDoubleUp\"></fa-icon>\n            </button>\n          </div>\n          <div class=\"input-group-prepend\">\n            <span class=\"input-group-text\">{{candidate.weight}}</span>\n          </div>\n          <div class=\"input-group-prepend\">\n            <span class=\"input-group-text\">{{candidate.word}}</span>\n          </div>\n          <div class=\"input-group-append\">\n            <button type=\"submit\" class=\"btn btn-danger\" (click)=\"chooseCantidate(candidate.word, -1)\">\n              <fa-icon [icon]=\"faAngleDoubleDown\"></fa-icon>\n            </button>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n  <div *ngIf=\"isVoting\">\n    <h5 class=\"text-muted\">\"{{vote.phrase}}\"</h5>\n    <div class=\"input-group mb-2\">\n      <div class=\"input-group-prepend\">\n        <span class=\"input-group-text\">Amount:</span>\n      </div>\n      <div class=\"input-group-prepend\">\n        <input #number [(ngModel)]=\"vote.weight\" type=\"number\" min=\"1\" (keyup)=\"integer()\">\n      </div>\n      <div class=\"input-group-append\">\n        <button type=\"submit\" class=\"btn\" [class.btn-success]=\"vote.weightPolarity>0\" [class.btn-danger]=\"vote.weightPolarity<0\"\n        (click)=\"submitVote()\">\n          {{vote.weightPolarity > 0 ? 'up' : 'down'}}-vote\n        </button>\n      </div>\n    </div>\n  </div>\n</div>\n"

        /***/
    }),

    /***/ "./src/app/story/candidates/candidates.component.ts":
    /*!**********************************************************!*\
      !*** ./src/app/story/candidates/candidates.component.ts ***!
      \**********************************************************/
    /*! exports provided: CandidatesComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "CandidatesComponent", function () {
            return CandidatesComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        /* harmony import */
        var _fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons/faAngleDoubleUp */ "./node_modules/@fortawesome/free-solid-svg-icons/faAngleDoubleUp.js");
        /* harmony import */
        var _fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(_fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1__);
        /* harmony import */
        var _fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons/faAngleDoubleDown */ "./node_modules/@fortawesome/free-solid-svg-icons/faAngleDoubleDown.js");
        /* harmony import */
        var _fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2__);
        /* harmony import */
        var _models_vote__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../models/vote */ "./src/app/models/vote.ts");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };


        var CandidatesComponent = /** @class */ (function () {
            function CandidatesComponent() {
                this.candidatesTitle = "Vote on the next candidate";
                this.candidatesEmptyMessage = "There are no candidates yet! Add a new word or phrase below";
                this.faAngleDoubleUp = _fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1__["faAngleDoubleUp"];
                this.faAngleDoubleDown = _fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2__["faAngleDoubleDown"];
                this.vote = new _models_vote__WEBPACK_IMPORTED_MODULE_3__["Vote"]('', 0);
                this.isVoting = false;
                this.clickEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
            }

            CandidatesComponent.prototype.ngOnInit = function () {
            };
            CandidatesComponent.prototype.chooseCantidate = function (s, n) {
                this.vote = new _models_vote__WEBPACK_IMPORTED_MODULE_3__["Vote"](s, n);
                this.isVoting = true;
            };
            CandidatesComponent.prototype.ngOnChanges = function (changes) {
                this.isVoting = false;
            };
            CandidatesComponent.prototype.integer = function () {
                var int = Math.floor(this.vote.weight);
                this.vote.weight = int < 1 ? 1 : Math.floor(this.vote.weight);
            };
            CandidatesComponent.prototype.submitVote = function () {
                this.clickEvent.emit(this.vote);
                this.isVoting = false;
            };
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
                __metadata("design:type", Array)
            ], CandidatesComponent.prototype, "candidates", void 0);
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
                __metadata("design:type", Object)
            ], CandidatesComponent.prototype, "clickEvent", void 0);
            CandidatesComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-candidates',
                    template: __webpack_require__(/*! ./candidates.component.html */ "./src/app/story/candidates/candidates.component.html")
                }),
                __metadata("design:paramtypes", [])
            ], CandidatesComponent);
            return CandidatesComponent;
        }());


        /***/
    }),

    /***/ "./src/app/story/story-display/countdown-timer/countdown-timer.component.html":
    /*!************************************************************************************!*\
      !*** ./src/app/story/story-display/countdown-timer/countdown-timer.component.html ***!
      \************************************************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<h3 class=\"text-right\">\n  {{count}}\n</h3>\n"

        /***/
    }),

    /***/ "./src/app/story/story-display/countdown-timer/countdown-timer.component.ts":
    /*!**********************************************************************************!*\
      !*** ./src/app/story/story-display/countdown-timer/countdown-timer.component.ts ***!
      \**********************************************************************************/
    /*! exports provided: CountdownTimerComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "CountdownTimerComponent", function () {
            return CountdownTimerComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };

        var CountdownTimerComponent = /** @class */ (function () {
            function CountdownTimerComponent() {
                this.count = "";
            }

            CountdownTimerComponent.prototype.ngOnInit = function () {
                this.initiateCountDown();
            };
            CountdownTimerComponent.prototype.initiateCountDown = function () {
                var _this = this;
                setInterval(function () {
                    var now = new Date().getTime();
                    var then = new Date(_this.updateTime).getTime();
                    var distance = then - now;
                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                    _this.count = (days > 0 ? days + "d " : "")
                        + (hours > 0 ? hours + "h " : "")
                        + (minutes > 0 ? minutes + "m " : "")
                        + seconds + "s ";
                }, 1000);
            };
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
                __metadata("design:type", String)
            ], CountdownTimerComponent.prototype, "updateTime", void 0);
            CountdownTimerComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-countdown-timer',
                    template: __webpack_require__(/*! ./countdown-timer.component.html */ "./src/app/story/story-display/countdown-timer/countdown-timer.component.html")
                }),
                __metadata("design:paramtypes", [])
            ], CountdownTimerComponent);
            return CountdownTimerComponent;
        }());


        /***/
    }),

    /***/ "./src/app/story/story-display/story-display.component.html":
    /*!******************************************************************!*\
      !*** ./src/app/story/story-display/story-display.component.html ***!
      \******************************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<h1 class=\"display-3 text-center text-light mb-4\">{{storyTitle}}</h1>\n<div class=\"container jumbotron\">\n  <div class=\"row\">\n    <div class=\"col-sm-9\">\n      <h2>{{storyDescription}}</h2>\n    </div>\n    <div class=\"col-sm-3\">\n      <app-countdown-timer [updateTime]=\"updateTime\"></app-countdown-timer>\n    </div>\n  </div>\n  <blockquote class=\"blockquote pl-4\">\n    <p *ngIf=\"!story || !story.length\">[Start a new story]</p>\n    <p>{{story}} <span class=\"text-muted font-italic\">{{phrase}}</span></p>\n    <footer class=\"blockquote-footer\">{{storyFooter}}</footer>\n  </blockquote>\n</div>\n"

        /***/
    }),

    /***/ "./src/app/story/story-display/story-display.component.ts":
    /*!****************************************************************!*\
      !*** ./src/app/story/story-display/story-display.component.ts ***!
      \****************************************************************/
    /*! exports provided: StoryDisplayComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "StoryDisplayComponent", function () {
            return StoryDisplayComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };

        var StoryDisplayComponent = /** @class */ (function () {
            function StoryDisplayComponent() {
                this.storyTitle = "Satoshi's Story";
                this.storyDescription = "A Test of Crowd Sourced Storytelling...";
                this.storyFooter = "The syndicate of Satoshi's storytellers";
            }

            StoryDisplayComponent.prototype.ngOnInit = function () {
            };
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
                __metadata("design:type", String)
            ], StoryDisplayComponent.prototype, "phrase", void 0);
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
                __metadata("design:type", String)
            ], StoryDisplayComponent.prototype, "story", void 0);
            __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
                __metadata("design:type", String)
            ], StoryDisplayComponent.prototype, "updateTime", void 0);
            StoryDisplayComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-story-display',
                    template: __webpack_require__(/*! ./story-display.component.html */ "./src/app/story/story-display/story-display.component.html")
                }),
                __metadata("design:paramtypes", [])
            ], StoryDisplayComponent);
            return StoryDisplayComponent;
        }());


        /***/
    }),

    /***/ "./src/app/story/story.component.html":
    /*!********************************************!*\
      !*** ./src/app/story/story.component.html ***!
      \********************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        module.exports = "<div>\n  <app-story-display [phrase]=\"storyAddition\" [story]=\"paragraph\" [updateTime]=\"story?.updateTime\"></app-story-display>\n  <app-candidates [candidates]=\"story?.candidates\" (clickEvent)=\"onVote($event)\"></app-candidates>\n  <app-add-candidate (phraseChanged)=\"onAddition($event)\" (buttonClicked)=\"onAddWord($event)\"></app-add-candidate>\n</div>\n"

        /***/
    }),

    /***/ "./src/app/story/story.component.ts":
    /*!******************************************!*\
      !*** ./src/app/story/story.component.ts ***!
      \******************************************/
    /*! exports provided: StoryComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "StoryComponent", function () {
            return StoryComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        /* harmony import */
        var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/@stomp/ng2-stompjs.es5.js");
        /* harmony import */
        var _services_story_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/story.service */ "./src/app/services/story.service.ts");
        var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
            var c = arguments.length,
                r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
            if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
            else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
            return c > 3 && r && Object.defineProperty(target, key, r), r;
        };
        var __metadata = (undefined && undefined.__metadata) || function (k, v) {
            if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
        };


        var StoryComponent = /** @class */ (function () {
            function StoryComponent(stompService, storyService) {
                this.stompService = stompService;
                this.storyService = storyService;
                this.paragraph = "";
            }

            StoryComponent.prototype.ngOnInit = function () {
                var _this = this;
                this.storyService.getStory().subscribe(function (story) {
                    _this.update(story);
                });
                // Open connection with server socket
                var subscription = this.stompService.subscribe('/topic/story');
                subscription.subscribe(function (message) {
                    _this.update(JSON.parse(message.body));
                    console.log(message.body);
                });
            };
            StoryComponent.prototype.update = function (story) {
                this.story = story;
                this.paragraph = this.story.words.join(' ');
            };
            StoryComponent.prototype.onAddition = function (phrase) {
                this.storyAddition = phrase;
            };
            StoryComponent.prototype.onAddWord = function (word) {
                this.storyService.addWord(word);
                this.storyAddition = null;
            };
            StoryComponent.prototype.onVote = function (vote) {
                this.storyService.vote(vote);
            };
            StoryComponent = __decorate([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
                    selector: 'app-story',
                    template: __webpack_require__(/*! ./story.component.html */ "./src/app/story/story.component.html")
                }),
                __metadata("design:paramtypes", [_stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__["StompService"],
                    _services_story_service__WEBPACK_IMPORTED_MODULE_2__["StoryService"]])
            ], StoryComponent);
            return StoryComponent;
        }());


        /***/
    }),

    /***/ "./src/environments/environment.ts":
    /*!*****************************************!*\
      !*** ./src/environments/environment.ts ***!
      \*****************************************/
    /*! exports provided: environment */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "environment", function () {
            return environment;
        });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
        var environment = {
            production: false
        };
        /*
         * In development mode, to ignore zone related error stack frames such as
         * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
         * import the following file, but please comment it out in production mode
         * because it will have performance impact when throw error
         */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


        /***/
    }),

    /***/ "./src/main.ts":
    /*!*********************!*\
      !*** ./src/main.ts ***!
      \*********************/
    /*! no exports provided */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
        /* harmony import */
        var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
        /* harmony import */
        var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
        /* harmony import */
        var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");


        if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
            Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
        }
        Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
            .catch(function (err) {
                return console.log(err);
            });


        /***/
    }),

    /***/ 0:
    /*!***************************!*\
      !*** multi ./src/main.ts ***!
      \***************************/
    /*! no static exports found */
    /***/ (function (module, exports, __webpack_require__) {

        module.exports = __webpack_require__(/*! C:\Users\Jeff Trimmer\IdeaProjects\StoryChainFE\src\main.ts */"./src/main.ts");


        /***/
    })

}, [[0, "runtime", "vendor"]]]);
//# sourceMappingURL=main.js.map