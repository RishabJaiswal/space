<h1>Space app</h1>

<h2>App packaging</h2>

<ul>
	<li>Production code is packaged by features | <a href="https://phauer.com/2020/package-by-feature/" target="_blank">reference</a></li>
	<li>Tests are packaged following default android packaging </li>
</ul>

<h2> App dependencies</h2>

<ul>
	<li>Hilt for dependency injection</li>
	<li>RxJava for reactive programing</li>
	<li>Gson for JSON deserialization</li>
	<li>Lottie for packaged animations</li>
	<li>Junit & mockito for unit testing & mocking</li>
	<li>Barista for UI tests</li>
</ul>


<h2> App architecture </h2>

<ul>
	<li>MVVM architecture with repository pattern | <a href="https://developer.android.com/jetpack/guide">reference</a></li>
  <li>Custom loading content pattern for state management | refer <a href="https://github.com/RishabJaiswal/space/blob/main/app/src/main/java/com/nasa/space/common/Result.kt">Result.kt</a> & <a href="https://github.com/RishabJaiswal/space/blob/main/app/src/main/java/com/nasa/space/common/LiveResult.kt">LiveResult.kt</a></li>
</ul>

<h2> Practises & pricinples </h2>

<ul>
	<li>Test Driven Developent for smaller tests</li>
  <li>Followed Clean Code to ensure common vocabulary with other Clean Code practioners</li>
	<li>Imperative mood with subject & body for git commit messaging | <a href = "https://chris.beams.io/posts/git-commit/"> reference </a>| <a href="https://initialcommit.com/blog/Git-Commit-Message-Imperative-Mood">infrenece</a></li>
</ul>

<h2> Important </h2>

<ul>
	<li>The given data is packaged with the app</li>
  <li>The api service is emulated by getting data locally</li>
  <li>The models to represent <i>Photo</i> for ui & data are <b>NOT</b> separated for <b>Space app</b> being a fairly simple use-case</li>
</ul>

<h2> App Demo </h2>

![Alt Text](https://github.com/RishabJaiswal/space/blob/main/demo.gif)