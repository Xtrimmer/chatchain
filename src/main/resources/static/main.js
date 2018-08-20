(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\r\n<nav class=\"navbar navbar-expand navbar-light bg-light\">\r\n  <a class=\"navbar-brand\">Satoshi's Stories</a>\r\n  <ul class=\"nav navbar-nav\">\r\n    <li><a class=\"nav-link\" [routerLink]=\"['/storylist']\">Stories</a></li>\r\n  </ul>\r\n</nav>\r\n<div class=\"main\" [@routerTransition]=\"getPage(appOutlet)\">\r\n  <div>\r\n    <router-outlet #appOutlet=\"outlet\"></router-outlet>\r\n  </div>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _router_animations__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./router.animations */ "./src/app/router.animations.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent.prototype.getPage = function (outlet) {
        return outlet.activatedRouteData['page'];
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            animations: [_router_animations__WEBPACK_IMPORTED_MODULE_1__["routerTransition"]],
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html")
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _story_story_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./story/story.component */ "./src/app/story/story.component.ts");
/* harmony import */ var _story_candidates_candidates_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./story/candidates/candidates.component */ "./src/app/story/candidates/candidates.component.ts");
/* harmony import */ var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "./node_modules/@fortawesome/angular-fontawesome/fesm5/angular-fontawesome.js");
/* harmony import */ var _story_add_candidate_add_candidate_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./story/add-candidate/add-candidate.component */ "./src/app/story/add-candidate/add-candidate.component.ts");
/* harmony import */ var _story_story_display_story_display_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./story/story-display/story-display.component */ "./src/app/story/story-display/story-display.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/@stomp/ng2-stompjs.es5.js");
/* harmony import */ var _config_stompConfig__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./config/stompConfig */ "./src/app/config/stompConfig.ts");
/* harmony import */ var _services_story_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./services/story.service */ "./src/app/services/story.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _story_story_display_countdown_timer_countdown_timer_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./story/story-display/countdown-timer/countdown-timer.component */ "./src/app/story/story-display/countdown-timer/countdown-timer.component.ts");
/* harmony import */ var _story_list_story_list_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./story-list/story-list.component */ "./src/app/story-list/story-list.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _story_list_create_story_create_story_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./story-list/create-story/create-story.component */ "./src/app/story-list/create-story/create-story.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
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
                _story_story_display_countdown_timer_countdown_timer_component__WEBPACK_IMPORTED_MODULE_13__["CountdownTimerComponent"],
                _story_list_story_list_component__WEBPACK_IMPORTED_MODULE_14__["StoryListComponent"],
                _story_list_create_story_create_story_component__WEBPACK_IMPORTED_MODULE_17__["CreateStoryComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_16__["BrowserAnimationsModule"],
                _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_5__["FontAwesomeModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_12__["HttpClientModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_15__["RouterModule"].forRoot([
                    { path: 'storylist', component: _story_list_story_list_component__WEBPACK_IMPORTED_MODULE_14__["StoryListComponent"], data: { page: 'list' } },
                    { path: 'story/:id', component: _story_story_component__WEBPACK_IMPORTED_MODULE_3__["StoryComponent"], data: { page: 'detail' } },
                    { path: '', redirectTo: 'storylist', pathMatch: 'full' },
                    { path: '**', redirectTo: 'storylist', pathMatch: 'full' }
                ]),
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



/***/ }),

/***/ "./src/app/config/stompConfig.ts":
/*!***************************************!*\
  !*** ./src/app/config/stompConfig.ts ***!
  \***************************************/
/*! exports provided: stompConfig */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "stompConfig", function() { return stompConfig; });
var stompConfig = {
    // Which server?
    url: 'ws://localhost:8080/socket/websocket',
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


/***/ }),

/***/ "./src/app/models/story.ts":
/*!*********************************!*\
  !*** ./src/app/models/story.ts ***!
  \*********************************/
/*! exports provided: Story */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Story", function() { return Story; });
var Story = /** @class */ (function () {
    function Story() {
    }
    return Story;
}());



/***/ }),

/***/ "./src/app/models/vote.ts":
/*!********************************!*\
  !*** ./src/app/models/vote.ts ***!
  \********************************/
/*! exports provided: Vote, VoteType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Vote", function() { return Vote; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VoteType", function() { return VoteType; });
var Vote = /** @class */ (function () {
    function Vote(phrase, weightPolarity) {
        this.weight = 1;
        this.phrase = phrase;
        this.voteType = weightPolarity;
    }
    return Vote;
}());

var VoteType;
(function (VoteType) {
    VoteType[VoteType["UPVOTE"] = 0] = "UPVOTE";
    VoteType[VoteType["DOWNVOTE"] = 1] = "DOWNVOTE";
})(VoteType || (VoteType = {}));


/***/ }),

/***/ "./src/app/router.animations.ts":
/*!**************************************!*\
  !*** ./src/app/router.animations.ts ***!
  \**************************************/
/*! exports provided: routerTransition */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "routerTransition", function() { return routerTransition; });
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");

var routerTransition = Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["trigger"])('routerTransition', [
    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["transition"])('* => list', [
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':enter, :leave', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ position: 'fixed', width: '100%' }), { optional: true }),
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["group"])([
            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':enter', [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(-100%)' }),
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["animate"])('0.5s ease-in-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(0%)' }))
            ], { optional: true }),
            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':leave', [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(0%)' }),
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["animate"])('0.5s ease-in-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(100%)' }))
            ], { optional: true }),
        ])
    ]),
    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["transition"])('* => detail', [
        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["group"])([
            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':enter, :leave', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ position: 'fixed', width: '100%' }), { optional: true }),
            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':enter', [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(100%)' }),
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["animate"])('0.5s ease-in-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(0%)' }))
            ], { optional: true }),
            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["query"])(':leave', [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(0%)' }),
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["animate"])('0.5s ease-in-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_0__["style"])({ transform: 'translateX(-100%)' }))
            ], { optional: true }),
        ])
    ])
]);


/***/ }),

/***/ "./src/app/services/story.service.ts":
/*!*******************************************!*\
  !*** ./src/app/services/story.service.ts ***!
  \*******************************************/
/*! exports provided: StoryService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoryService", function() { return StoryService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/internal/observable/throwError */ "./node_modules/rxjs/internal/observable/throwError.js");
/* harmony import */ var rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(rxjs_internal_observable_throwError__WEBPACK_IMPORTED_MODULE_3__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
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
        this.url = 'http://localhost:8080/api/';
    }
    StoryService.prototype.getStory = function (id) {
        return this.http.get(this.url + 'story/' + id)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (data) { return console.log('Single: ' + JSON.stringify(data)); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(this.handleError));
    };
    StoryService.prototype.getStories = function () {
        return this.http.get(this.url + 'stories')
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (data) { return console.log('Single: ' + JSON.stringify(data)); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(this.handleError));
    };
    StoryService.prototype.addPhrase = function (storyId, phrase) {
        this.http.post(this.url + 'add/candidate/' + storyId, phrase)
            .subscribe(function (resp) {
            console.log('response %o, ', resp);
        });
    };
    StoryService.prototype.vote = function (storyId, vote) {
        var options = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Content-Type': 'application/json'
            })
        };
        var object = JSON.stringify(vote);
        this.http.post(this.url + 'vote/' + storyId, object, options)
            .subscribe(function (resp) {
            console.log('response %o, ', resp);
        });
    };
    StoryService.prototype.addNewStory = function (story) {
        var options = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Content-Type': 'application/json'
            })
        };
        var object = JSON.stringify(story);
        return this.http.post(this.url + 'add/story/', object, options);
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



/***/ }),

/***/ "./src/app/story-list/create-story/create-story.component.css":
/*!********************************************************************!*\
  !*** ./src/app/story-list/create-story/create-story.component.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".ng-valid[required], .ng-valid.required {\r\n  border-left: 5px solid #42A948;\r\n}\r\n\r\n.ng-invalid:not(form) {\r\n  border-left: 5px solid #a94442;\r\n}\r\n"

/***/ }),

/***/ "./src/app/story-list/create-story/create-story.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/story-list/create-story/create-story.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<button class=\"btn btn-success btn-sm btn-block\" (click)=\"toggleForm()\">Create a new Story</button>\r\n<div *ngIf=\"showForm\">\r\n  <div class=\"container jumbotron mt-3\">\r\n    <form #createStoryForm=\"ngForm\">\r\n      <h3>Create a new Story</h3>\r\n      <div class=\"form-group\">\r\n        <label for=\"title\">Title</label>\r\n        <input id=title class=\"form-control\" placeholder=\"The Best Story Ever\" maxlength=\"50\" type=\"text\"\r\n               required [(ngModel)]=\"story.title\" name=\"title\" #title=\"ngModel\">\r\n        <div [hidden]=\"title.valid || title.pristine\" class=\"alert alert-danger\">\r\n          A title is required ( Even if it is something ludicrous like \"The Manly Art of Knitting\" )\r\n        </div>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"citation\">Author</label>\r\n        <input id=citation class=\"form-control\" maxlength=\"50\"\r\n               name=\"citation\" type=\"text\" required [(ngModel)]=\"story.citation\" #citation=\"ngModel\">\r\n        <div [hidden]=\"citation.valid || citation.pristine\" class=\"alert alert-danger\">\r\n          An author is required ( Even if it is someone lame like Stephenie Meyer or L. Ron Hubbard )\r\n        </div>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"period\">Round Period in Minutes</label>\r\n        <input id=period class=\"form-control\" name=\"period\" type=\"number\" min=\"0\" max=\"3600\"\r\n               pattern=\"([1-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[12][0-9]{3}|3[0-5][0-9]{2}|3600)\"\r\n               required [(ngModel)]=\"story.period\" #period=\"ngModel\">\r\n        <div [hidden]=\"period.valid\" class=\"alert alert-danger\">\r\n          A number between 1 and 3600 is Required ( Unfortunately stories cannot travel backwards in time and waiting\r\n          longer than a day for an update just pisses people off )\r\n        </div>\r\n      </div>\r\n      <button type=\"submit\" class=\"btn btn-success\" (click)=\"onSubmit()\" [disabled]=\"!createStoryForm.form.valid\">\r\n        Submit\r\n      </button>\r\n      <button type=\"submit\" class=\"btn btn-danger ml-2\" (click)=\"toggleForm()\">Cancel</button>\r\n    </form>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/story-list/create-story/create-story.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/story-list/create-story/create-story.component.ts ***!
  \*******************************************************************/
/*! exports provided: CreateStoryComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateStoryComponent", function() { return CreateStoryComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_story__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/story */ "./src/app/models/story.ts");
/* harmony import */ var _services_story_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/story.service */ "./src/app/services/story.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CreateStoryComponent = /** @class */ (function () {
    function CreateStoryComponent(storyService) {
        this.storyService = storyService;
        this.showForm = false;
        this.formSubmitted = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.story = new _models_story__WEBPACK_IMPORTED_MODULE_1__["Story"]();
        this.story.citation = "The syndicate of Satoshi's storytellers";
        this.story.period = 60;
    }
    CreateStoryComponent.prototype.toggleForm = function () {
        this.showForm = !this.showForm;
    };
    CreateStoryComponent.prototype.onSubmit = function () {
        var _this = this;
        this.storyService.addNewStory(this.story)
            .subscribe(function (story) {
            return _this.formSubmitted.emit(story);
        });
        this.showForm = false;
        this.story.period = 60;
        this.story.citation = "The syndicate of Satoshi's storytellers";
        this.story.title = null;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"])
    ], CreateStoryComponent.prototype, "formSubmitted", void 0);
    CreateStoryComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-create-story',
            template: __webpack_require__(/*! ./create-story.component.html */ "./src/app/story-list/create-story/create-story.component.html"),
            styles: [__webpack_require__(/*! ./create-story.component.css */ "./src/app/story-list/create-story/create-story.component.css")]
        }),
        __metadata("design:paramtypes", [_services_story_service__WEBPACK_IMPORTED_MODULE_2__["StoryService"]])
    ], CreateStoryComponent);
    return CreateStoryComponent;
}());



/***/ }),

/***/ "./src/app/story-list/story-list.component.css":
/*!*****************************************************!*\
  !*** ./src/app/story-list/story-list.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".jumbotron-min {\r\n  padding: 0.5rem;\r\n  background-color: #e9ecef;\r\n  border-radius: 0.3rem;\r\n  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;\r\n}\r\n\r\n.jumbotron-min:hover {\r\n  background-color: #cdcdcd;\r\n}\r\n\r\na {\r\n  text-decoration: none;\r\n  color: #212529;\r\n}\r\n"

/***/ }),

/***/ "./src/app/story-list/story-list.component.html":
/*!******************************************************!*\
  !*** ./src/app/story-list/story-list.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container mt-4\">\r\n  <h1 class=\"display-4 text-center text-light mb-4\">Story List</h1>\r\n  <app-create-story (formSubmitted)=\"onStoryCreated($event)\"></app-create-story>\r\n  <div *ngFor=\"let story of stories\">\r\n    <a [routerLink]=\"['/story', story.id]\">\r\n      <div class=\"jumbotron-min mt-3\">\r\n        <div class=\"row\">\r\n          <div class=\"col-md-2\">\r\n            <h2 class=\"text-center\">{{story.totalValue}}</h2>\r\n          </div>\r\n          <div class=\"col\">\r\n            <h4 class=\"text-center text-md-left\">{{story?.title}}</h4>\r\n            <p class=\"text-center text-md-left\">{{preview(story)}}</p>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </a>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/story-list/story-list.component.ts":
/*!****************************************************!*\
  !*** ./src/app/story-list/story-list.component.ts ***!
  \****************************************************/
/*! exports provided: StoryListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoryListComponent", function() { return StoryListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_story_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/story.service */ "./src/app/services/story.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var StoryListComponent = /** @class */ (function () {
    function StoryListComponent(storyService, router) {
        this.storyService = storyService;
        this.router = router;
    }
    StoryListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.storyService.getStories().subscribe(function (stories) { return _this.stories = stories; });
    };
    StoryListComponent.prototype.preview = function (story) {
        var fullStory = '';
        if (story && story.phrases && story.phrases.length) {
            story.phrases.forEach(function (a) { return fullStory += a.phrase + ' '; });
            if (fullStory.length > 0) {
                fullStory = fullStory.substring(0, fullStory.length - 1);
            }
        }
        else {
            fullStory = '[Add a new candidate to begin this story]';
        }
        if (fullStory.length > 100) {
            return fullStory.substring(0, 100) + '...';
        }
        return fullStory;
    };
    StoryListComponent.prototype.onStoryCreated = function (story) {
        this.router.navigate(['../story', story.id]);
    };
    StoryListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-story-list',
            template: __webpack_require__(/*! ./story-list.component.html */ "./src/app/story-list/story-list.component.html"),
            styles: [__webpack_require__(/*! ./story-list.component.css */ "./src/app/story-list/story-list.component.css")]
        }),
        __metadata("design:paramtypes", [_services_story_service__WEBPACK_IMPORTED_MODULE_1__["StoryService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], StoryListComponent);
    return StoryListComponent;
}());



/***/ }),

/***/ "./src/app/story/add-candidate/add-candidate.component.html":
/*!******************************************************************!*\
  !*** ./src/app/story/add-candidate/add-candidate.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container text-light\">\r\n  <h2>Or add a new one</h2>\r\n  <label class=\"control-label sr-only\" for=\"phrase\">Enter phrase</label>\r\n  <div class=\"input-group\">\r\n    <input class=\"form-control\" id=\"phrase\" type=\"text\" placeholder=\"Enter your phrase here\"\r\n           [(ngModel)]=\"phrase\" (keyup)=\"onType()\">\r\n    <div class=\"input-group-append\">\r\n      <span class=\"input-group-text\">satoshi: {{cost}}</span>\r\n    </div>\r\n    <div class=\"input-group-append\">\r\n      <input class=\"btn btn-success\" type=\"submit\" value=\"add\"\r\n             (click)=\"onClick()\">\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/story/add-candidate/add-candidate.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/story/add-candidate/add-candidate.component.ts ***!
  \****************************************************************/
/*! exports provided: AddCandidateComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddCandidateComponent", function() { return AddCandidateComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
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
        this.cost = this.fib(this.phrase.trim().length);
    };
    AddCandidateComponent.prototype.onClick = function () {
        if (this.phrase && this.phrase.length) {
            this.buttonClicked.emit(this.phrase);
            this.phrase = null;
            this.cost = 0;
        }
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



/***/ }),

/***/ "./src/app/story/candidates/candidates.component.html":
/*!************************************************************!*\
  !*** ./src/app/story/candidates/candidates.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container mb-5\">\r\n  <h2 class=\"text-light\">{{candidatesTitle}}</h2>\r\n  <div *ngIf=\"!isVoting\">\r\n    <div *ngIf=\"!candidates || !candidates.length\">\r\n      <p class=\"text-muted\">{{candidatesEmptyMessage}}</p>\r\n    </div>\r\n    <div class=\"form-row\">\r\n      <div class=\"col-auto\"\r\n           *ngFor=\"let candidate of candidates\">\r\n        <div class=\"input-group mb-2\">\r\n          <div class=\"input-group-prepend\">\r\n            <button type=\"submit\" class=\"btn btn-success\" (click)=\"chooseCantidate(candidate.phrase, VoteType.UPVOTE)\">\r\n              <fa-icon [icon]=\"faAngleDoubleUp\"></fa-icon>\r\n            </button>\r\n          </div>\r\n          <div class=\"input-group-prepend\">\r\n            <span class=\"input-group-text\">{{candidate.weight}}</span>\r\n          </div>\r\n          <div class=\"input-group-prepend\">\r\n            <span class=\"input-group-text\">{{candidate.phrase}}</span>\r\n          </div>\r\n          <div class=\"input-group-append\">\r\n            <button type=\"submit\" class=\"btn btn-danger\" (click)=\"chooseCantidate(candidate.phrase, VoteType.DOWNVOTE)\">\r\n              <fa-icon [icon]=\"faAngleDoubleDown\"></fa-icon>\r\n            </button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div *ngIf=\"isVoting\">\r\n    <h5 class=\"text-muted\">\"{{vote.phrase}}\"</h5>\r\n    <div class=\"input-group mb-2\">\r\n      <div class=\"input-group-prepend\">\r\n        <span class=\"input-group-text\">Amount:</span>\r\n      </div>\r\n      <div class=\"input-group-prepend\">\r\n        <input #number [(ngModel)]=\"vote.weight\" type=\"number\" min=\"1\" (keyup)=\"integer()\">\r\n      </div>\r\n      <div class=\"input-group-append\">\r\n        <button type=\"submit\" class=\"btn\" [class.btn-success]=\"vote.voteType == VoteType.UPVOTE\"\r\n                [class.btn-danger]=\"vote.voteType == VoteType.DOWNVOTE\"\r\n                (click)=\"submitVote()\">\r\n          {{vote.voteType == VoteType.UPVOTE ? 'up' : 'down'}}-vote\r\n        </button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/story/candidates/candidates.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/story/candidates/candidates.component.ts ***!
  \**********************************************************/
/*! exports provided: CandidatesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CandidatesComponent", function() { return CandidatesComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons/faAngleDoubleUp */ "./node_modules/@fortawesome/free-solid-svg-icons/faAngleDoubleUp.js");
/* harmony import */ var _fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(_fortawesome_free_solid_svg_icons_faAngleDoubleUp__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons/faAngleDoubleDown */ "./node_modules/@fortawesome/free-solid-svg-icons/faAngleDoubleDown.js");
/* harmony import */ var _fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_fortawesome_free_solid_svg_icons_faAngleDoubleDown__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _models_vote__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../models/vote */ "./src/app/models/vote.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
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
        this.VoteType = _models_vote__WEBPACK_IMPORTED_MODULE_3__["VoteType"];
        this.isVoting = false;
        this.clickEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
    }
    CandidatesComponent.prototype.ngOnInit = function () {
    };
    CandidatesComponent.prototype.chooseCantidate = function (s, t) {
        this.vote = new _models_vote__WEBPACK_IMPORTED_MODULE_3__["Vote"](s, t);
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



/***/ }),

/***/ "./src/app/story/story-display/countdown-timer/countdown-timer.component.html":
/*!************************************************************************************!*\
  !*** ./src/app/story/story-display/countdown-timer/countdown-timer.component.html ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h3 class=\"text-right\">\r\n  {{count}}\r\n</h3>\r\n"

/***/ }),

/***/ "./src/app/story/story-display/countdown-timer/countdown-timer.component.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/story/story-display/countdown-timer/countdown-timer.component.ts ***!
  \**********************************************************************************/
/*! exports provided: CountdownTimerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CountdownTimerComponent", function() { return CountdownTimerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var CountdownTimerComponent = /** @class */ (function () {
    function CountdownTimerComponent() {
        this.count = "0s";
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
            if (distance > 0) {
                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                _this.count = (days > 0 ? days + "d " : "")
                    + (hours > 0 ? hours + "h " : "")
                    + (minutes > 0 ? minutes + "m " : "")
                    + seconds + "s ";
            }
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



/***/ }),

/***/ "./src/app/story/story-display/story-display.component.html":
/*!******************************************************************!*\
  !*** ./src/app/story/story-display/story-display.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container jumbotron pt-3\">\r\n  <div class=\"row\">\r\n    <div class=\"col\">\r\n      <app-countdown-timer [updateTime]=\"story?.updateTime\"></app-countdown-timer>\r\n    </div>\r\n  </div>\r\n  <blockquote class=\"blockquote pl-4\">\r\n    <p>{{paragraph}} <span class=\"text-muted font-italic\">{{phrase}}</span></p>\r\n    <footer class=\"blockquote-footer\">{{story?.citation}}</footer>\r\n  </blockquote>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/story/story-display/story-display.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/story/story-display/story-display.component.ts ***!
  \****************************************************************/
/*! exports provided: StoryDisplayComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoryDisplayComponent", function() { return StoryDisplayComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_story__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/story */ "./src/app/models/story.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var StoryDisplayComponent = /** @class */ (function () {
    function StoryDisplayComponent() {
    }
    StoryDisplayComponent.prototype.ngOnInit = function () {
    };
    StoryDisplayComponent.prototype.ngOnChanges = function (changes) {
        var fullPhrase = '';
        if (this.story && this.story.phrases && this.story.phrases.length) {
            this.story.phrases.forEach(function (a) { return fullPhrase += a.phrase + ' '; });
            if (fullPhrase.length > 0) {
                fullPhrase = fullPhrase.substring(0, fullPhrase.length - 1);
            }
        }
        else {
            fullPhrase = '[Add a new candidate to begin this story]';
        }
        this.paragraph = fullPhrase;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", String)
    ], StoryDisplayComponent.prototype, "phrase", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_story__WEBPACK_IMPORTED_MODULE_1__["Story"])
    ], StoryDisplayComponent.prototype, "story", void 0);
    StoryDisplayComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-story-display',
            template: __webpack_require__(/*! ./story-display.component.html */ "./src/app/story/story-display/story-display.component.html")
        }),
        __metadata("design:paramtypes", [])
    ], StoryDisplayComponent);
    return StoryDisplayComponent;
}());



/***/ }),

/***/ "./src/app/story/story.component.html":
/*!********************************************!*\
  !*** ./src/app/story/story.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <h1 class=\"display-4 text-center text-light mb-4\">{{story?.title}}</h1>\r\n  <app-story-display [phrase]=\"storyAddition\" [story]=\"story\"></app-story-display>\r\n  <app-candidates [candidates]=\"story?.candidates\" (clickEvent)=\"onVote($event)\"></app-candidates>\r\n  <app-add-candidate (phraseChanged)=\"onAddition($event)\" (buttonClicked)=\"onAddPhrase($event)\"></app-add-candidate>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/story/story.component.ts":
/*!******************************************!*\
  !*** ./src/app/story/story.component.ts ***!
  \******************************************/
/*! exports provided: StoryComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoryComponent", function() { return StoryComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/@stomp/ng2-stompjs.es5.js");
/* harmony import */ var _services_story_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/story.service */ "./src/app/services/story.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var StoryComponent = /** @class */ (function () {
    function StoryComponent(stompService, storyService, route) {
        this.stompService = stompService;
        this.storyService = storyService;
        this.route = route;
    }
    StoryComponent.prototype.ngOnInit = function () {
        var _this = this;
        var storyId = this.route.snapshot.paramMap.get('id');
        this.storyService.getStory(storyId).subscribe(function (story) {
            _this.story = story;
            // Open connection with server socket
            var webSocketObservable = _this.stompService.subscribe('/topic/story/' + _this.story.id);
            _this.webSocketSubscription = webSocketObservable.subscribe(function (message) {
                _this.story = JSON.parse(message.body);
                console.log(message.body);
            });
        });
    };
    StoryComponent.prototype.onAddition = function (phrase) {
        this.storyAddition = phrase;
    };
    StoryComponent.prototype.onAddPhrase = function (phrase) {
        this.storyService.addPhrase(this.story.id, phrase);
        this.storyAddition = null;
    };
    StoryComponent.prototype.onVote = function (vote) {
        this.storyService.vote(this.story.id, vote);
    };
    StoryComponent.prototype.ngOnDestroy = function () {
        this.webSocketSubscription.unsubscribe();
    };
    StoryComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-story',
            template: __webpack_require__(/*! ./story.component.html */ "./src/app/story/story.component.html")
        }),
        __metadata("design:paramtypes", [_stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__["StompService"],
            _services_story_service__WEBPACK_IMPORTED_MODULE_2__["StoryService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]])
    ], StoryComponent);
    return StoryComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
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


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\UserName\IU\StoryChainFE\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map