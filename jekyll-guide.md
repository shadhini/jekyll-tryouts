# Jekyll Guide

`Jekyll – static site generator`; 
* it has to build the site before we can view it

`Gemfile` – for dependency management

`Bundler` – manages Ruby gem dependencies

## 1. Setup

### 1.1. Installation
* Install `Ruby on your machine, if not installed
    ```bash
    brew install ruby
    ruby -v
    ```

* Navigate to the git repo/branch and the docs directory from **where you want to publish the site**
    ```bash
    cd docs
    ```

* Install Jekyll from the terminal
    ```bash
    gem install jekyll bundler
    ```

* Create a new `Gemfile` to list project’s **dependencies**
    ```bash
    bundle init
    ```

* Edit the `Gemfile` in a text editor and add jekyll as a dependency:
  ```
  gem "jekyll"
  ```
  ```ruby
  source "https://rubygems.org"
  gem "jekyll"
  ```

Run bundle to install jekyll for project
```bash
bundle
```

---

* You can now **prefix** all jekyll commands listed in this guide 
with `bundle exec` to make sure you use the jekyll version defined in the `Gemfile`.

---

### 1.2. Create a site

Create `index.html` or `index.md` in docs root directory

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
  </head>
  <body>
    <h1>Hello World!</h1>
  </body>
</html>
```

```markdown
# Home
## Hello World! 
```

### 1.3. Build
* Run either of the following commands to build the site:
  * `jekyll build` - Builds the site and outputs a static site to a directory called **_site**
  
    OR
  
  * `jekyll serve` - Does jekyll build and runs it on a local web server at http://localhost:4000, 
  rebuilding the site any time you make a change.

---
* When you’re developing a site, use `jekyll serve`.
---

* To force the browser to refresh with every change
  ```bash
  jekyll serve --livereload
  ```

* If there’s a conflict, or you’d like Jekyll to serve your development site at a different URL, 

  use the `--host` and `--port` arguments


* The version of the site that jekyll serve builds in `_site` is **not suited for deployment**. 
  * Links and asset URLs in sites created with jekyll serve will use https://localhost:4000 or 
  * the value set with command-line configuration, instead of the values set in your site’s configuration file.


## 2. Liquid
`Templating language` 

###### Use Liquid

To make Jekyll process your changes, add front matter to the top of the page

```markdown
---
# front matter tells Jekyll to process Liquid
---
```

Liquid has 3 main components

### 2.1. Objects
output predefined variables as content on a page

```js
{{ page.title }} // displays the page.title variable
```

### 2.2. Tags
define the logic and control flow for templates

```js
{% if page.show_sidebar %}
  <div class="sidebar">
    sidebar content
  </div>
{% endif %}
// displays the sidebar if the value of the show_sidebar page variable is true.
```

[Liquid Tags](https://jekyllrb.com/docs/liquid/tags/)

### 2.3. Filters
change the output of a Liquid object

They are used within an output and are separated by a `|`

```js
{{ "hi" | capitalize }} // displays Hi instead of hi
```

[Liquid Filters](https://jekyllrb.com/docs/liquid/filters/)

## 3. Front Matter
`Front matter` must be included on the page for Jekyll to process any `Liquid` tags on it

**Front matter**: a snippet of **YAML** placed between two triple-dashed lines at the start of a file
```markdown
---
my_number: 5
---
```
* front matter can be used to set variables for the page
  ```js
  {{ page.my_number }}
  ```

E.g:
```html
---
title: Home
---
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>{{ page.title }}</title>
  </head>
  <body>
    <h1>{{ "Hello World!" | downcase }}</h1>
  </body>
</html>
```

```markdown
---
title: Home
---

# {{ page.title }}

## {{ "Hello World!" | downcase }}
```


## 4. Layouts
Jekyll supports **Markdown** in addition to **HTML** when building pages.

### 4.1. Creating a Layout
Layouts are **templates** that can be used by any page in your site and wrap around page content.

They are stored in a directory called `_layouts`.

Create the `_layouts` directory in your site’s root folder and create a new `default.html` file.

```html
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>{{ page.title }}</title>  <!-- browser tab title -->
</head>
<body>
{{ content }}
</body>
</html>
```

Compared to html files with content, layout...
* has **no front matter**
* the content of the page is replaced by a `content` variable. 
  * **content**: a special variable that returns the rendered content of the page on which it’s called.

### 4.2. Use layouts
Add the layout variable in the front matter of about.md/about.html to use new layout in the About page:

```html
---
layout: default
title: About
---
<p>{{ "about content" | upcase }}</p>
```

```markdown
---
layout: default
title: About
---
{{ "about content" | upcase }}
```

Open http://localhost:4000/about.html in your browser


## 5. Includes
`to navigate between pages`

Navigation should be on every page so adding it to your **layout** is the correct place to do this.
   
### 5.1. `Include` tag
Allows you to include content from another file stored in an `_includes` folder.

* useful for having a single source for source code that repeats around the site or for improving the readability.

### 5.2. Include usage
Create a file for the navigation at `_includes/navigation.html` 
```html
<nav>
    <a href="/">Home</a>
    <a href="/about.html">About</a>
</nav>
```

Use the include tag to add the navigation to `_layouts/default.html`:

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>{{ page.title }}</title>
  </head>
  <body>
    {% include navigation.html %}
    {{ content }}
  </body>
</html>
```

Open http://localhost:4000 in your browser and try switching between the pages.

### 5.3. Current page highlighting
`_includes/navigation.html` needs to know the URL of the page it’s inserted into so it can add styling.

Using `page.url` variable you can check if each link is the current page and color it **red** if **true**:

```html
<nav>
  <a href="/" {% if page.url == "/" %}style="color: red;"{% endif %}>
    Home
  </a>
  <a href="/about.html" {% if page.url == "/about.html" %}style="color: red;"{% endif %}>
    About
  </a>
</nav>
```


Take a look at http://localhost:4000 


## 6. Data Files
Jekyll supports loading data from **YAML**, **JSON**, and **CSV** files located in a `_data` directory.

### 6.1. Data file usage
Use **YAML** to store an array of navigation items each with a name and link.

Create a data file for the navigation at `_data/navigation.yml` 
```yaml
- name: Home
  link: /
- name: About
  link: /about.html
```

Jekyll makes this data file available to you at `site.data.navigation`.

Instead of outputting each link in `_includes/navigation.html`, now you can iterate over the data file instead:

```html
<nav>
  {% for item in site.data.navigation %}
    <a href="{{ item.link }}" {% if page.url == item.link %}style="color: red;"{% endif %}>
      {{ item.name }}
    </a>
  {% endfor %}
</nav>
```

## 7. Assets
Place  **CSS**, **JS**, **images** and **other assets** in your `site` folder and they’ll copy across to the built site.

assets structure:
```text
.
├── assets
│   ├── css
│   ├── images
│   └── js
...
```

### 7.1. Sass 

`Sass is a fantastic extension to CSS baked right into Jekyll`
* Can use standard CSS files for styling.

location: `_sass` folder directly under the root

* **Inlining** the styles used in `_includes/navigation.html` is **not a best practice**.

##### Sass Usage

* stylesheet file: `assets/css/styles.scss` 
  ```scss
  
  ---
  ---
  // Empty front matter at the top:  tells Jekyll it needs to process the file.
  @import "main";
  // @import "main": tells Sass to look for a file called main.scss in the sass directory (_sass/) by default
    ```
  
* sass file: `_sass/main.scss` 
  ```scss
  // Create a class named "current" in order to color the current link green. 
  .current {
  color: green;
  }
  ```                                                                                                              

* reference the stylesheet in layout: `_layouts/default.html` by adding the stylesheet to the `<head>`

  ```html
  <!doctype html>
  <html>
    <head>
      <meta charset="utf-8">
      <title>{{ page.title }}</title>
      <link rel="stylesheet" href="/assets/css/styles.css">
    </head>
    <body>
      {% include navigation.html %}
      {{ content }}
    </body>
  </html>
  ```
   * The `styles.css` referenced here is generated by Jekyll from the `styles.scss`  created in `assets/css/.`


* style usage in html files by referring to the class:

  `navigation.html`
  ```html
  <nav>
    {% for item in site.data.navigation %}
      <a href="{{ item.link }}" {% if page.url == item.link %}class="current"{% endif %}>{{ item.name }}</a>
    {% endfor %}
  </nav>
  ```

* Load up http://localhost:4000 

## 8. Blogging
`Blog without a database.`
In Jekyll style, blogging is powered by **text files only**.

### 8.1. Posts
folder for blog posts: `_posts`

Filename format for posts: [PUBLISH_DATE_YYYY:MM:DD]-[TITLE].[EXTENSION]

* an example post: `_posts/2025-02-10-blog1-file-name.md`

  ```markdown
  ---
  layout: post
  author: jill
  title: Blog1 Title
  ---
  
  # Welcome to Jekyll Posts 
  
  This is an example of a blog post.
  ```

  - **author** is a custom variable 
  
* post layout: `_layouts/post.html`:
  ```html
  ---
  layout: default
  ---
  <h1>{{ page.title }}</h1>
  <p>{{ page.date | date_to_string }} - {{ page.author }}</p>
  
  {{ content }}
  ```

  - This is an example of **layout inheritance**.
  - `date_to_string` **filter** formats a date into a nicer format.

### 8.2. Listing posts
Jekyll makes posts available at `site.posts`.

* `blogs.html` in your root (/blogs.html) - the page which lists all the posts

  ```html
  ---
  layout: default
  title: Blog
  ---
  <h1>Latest Posts</h1>
  
  <ul>
    {% for post in site.posts %}
      <li>
        <h2><a href="{{ post.url }}">{{ post.title }}</a></h2>
        {{ post.excerpt }}
      </li>
    {% endfor %}
  </ul>
  ```

    - `post.url`: automatically set by Jekyll to the output path of the post 
    - `post.title`: pulled from the post filename and can be overridden by setting title in front matter
    - `post.excerpt`: the first paragraph of content by default

* `_data/navigation.yml` with an entry for the blogs page

  ```yml
  - name: Home
    link: /
  - name: About
    link: /about.html
  - name: Blog
    link: /blogs.html
  ```

* Add few more posts and open http://localhost:4000 

## 9. Front matter defaults
Configure
* all **posts** to automatically have the **post layout**,
* **authors** to have **author layout**, and
* everything else to use the **default layout**.
---

* Using front matter defaults in `_config.yml` set a scope of what the default applies to,
  * then the default front matter you’d like.
    ```yaml
    collections:
      authors:
        output: true
    
    defaults:
    - scope:
        path: ""
        type: "authors"
      values:
        layout: "author"
    - scope:
        path: ""
        type: "posts"
      values:
        layout: "post"
    - scope:
        path: ""
      values:
        layout: "default"
    ```

* Now you can remove layout from the front matter of all pages and posts.
* Note that any time you update `_config.yml` you’ll need to restart Jekyll for the changes to take effect.


## 10. Collections
Collections are **similar to posts** except the **content doesn’t have to be grouped by date**.

### 10.1. Configuration
default jekyll configuration file: `_config.yml` @ root directory for gh pages 

```yaml
collections:
  authors:
```

* To (re)load the configuration, restart the jekyll server. 
  * Press `Ctrl+C` in your terminal to stop the server, and 
  * then `jekyll serve` to restart it.

### 10.2. Usage Example
**Documents** (the items in a collection) live in a folder in the root of the site named `_<COLLECTION_NAME>`.

Jekyll makes the collection available at `site.<COLLECTION_NAME>`.

By **default**, collections **do not output a page for documents**.


##### `authors` collection
###### Add authors

* a document for each author:
  * `_authors/jill.md`
     ```markdown
      ---
      short_name: jill
      name: Jill Smith
      position: Chief Editor
      ---
      Jill is an avid fruit grower based in the south of France.
      
      ```
* Jekyll makes the collection available at `site.authors`.

* **Authors page** - a page which lists all the authors on the site

  ```html
  ---
  layout: default
  title: Authors
  ---
  <h1>Authors</h1>
  
  <ul>
    {% for author in site.authors %}
      <li>
        <h2>{{ author.name }}</h2>
        <h3>{{ author.position }}</h3>
        <p>{{ author.content | markdownify }}</p>
      </li>
    {% endfor %}
  </ul>
  ```

  * Since the content is markdown, you need to run it through the `markdownify` filter. 
  * This happens automatically when outputting using `{{ content }}` in a layout.
  

* add an entry for the authors page: `_data/navigation.yml`  
  ```yaml
  - name: Home
    link: /
  - name: About
    link: /about.html
  - name: Blog
    link: /blogs.html
  - name: Staff
    link: /authors.html
  ```

###### Output pages of authors so that each author has their own page
* By **default**, collections **do not output a page for documents**. 

* configuration: setting `output: true` in the author collection configuration in `_config.yml`
  ```yaml
  collections:
    authors:
      output: true
  ```
* Restart the jekyll server for the configuration changes to take effect. 
* Link to the output page using `author.url` in `authors.html` page

  ```html
  ---
  layout: default
  title: Authors
  ---
  <h1>Authors</h1>
  
  <ul>
    {% for author in site.authors %}
      <li>
        <h2><a href="{{ author.url }}">{{ author.name }}</a></h2>
        <h3>{{ author.position }}</h3>
        <p>{{ author.content | markdownify }}</p>
      </li>
    {% endfor %}
  </ul>
  ```

* Author pages layout: `_layouts/author.html`
  ```html
  ---
  layout: default
  ---
  <h1>{{ page.name }}</h1>
  <h2>{{ page.position }}</h2>
  
  {{ content }}
  ```


###### List author’s posts
List the posts an author has published on their page.

* Iterate over this filtered list in `_layouts/author.html` to output the author’s posts:
  ```html
  ---
  layout: default
  ---
  <h1>{{ page.name }}</h1>
  <h2>{{ page.position }}</h2>
  
  {{ content }}
  
  <h2>Posts</h2>
  <ul>
    <!-- loops through `site.posts` and keeps only those posts 
    where the `author` front matter in each post matches the value of `page.short_name` -->
    {% assign filtered_posts = site.posts | where: 'author', page.short_name %}
  
    {% for post in filtered_posts %}
      <li><a href="{{ post.url }}">{{ post.title }}</a></li>
    {% endfor %}
  </ul>
  ```

###### Link to authors page from the post
The posts have a reference to the author so let’s link it to the author’s page. 
* in `_layouts/post.html`:
  ```html
  ---
  layout: default
  ---
  <h1>{{ page.title }}</h1>
  
  <p>
    {{ page.date | date_to_string }}
    <!-- Link to author's page-->
    {% assign author = site.authors | where: 'short_name', page.author | first %}
    {% if author %}
      - <a href="{{ author.url }}">{{ author.name }}</a>
    {% endif %}
  </p>
  
  {{ content }}
  ```

* Open up http://localhost:4000 


## 11. Deployment
`Get the site ready for production`

### 11.1. Gemfile & Bundle

`Gemfile`:  ensures the version of Jekyll and other gems remains consistent across different environments.
- file should be called ‘Gemfile’ and should not have any extension


`Bundler`: installs the gems and 
creates a `Gemfile.lock` which locks the current gem versions for a future bundle install


###### Create Gemfile with Bundler and then add the jekyll gem:

    bundle init
    bundle add jekyll

Gemfile
```
# frozen_string_literal: true
source "https://rubygems.org"

gem "jekyll"
```

###### Update the gem versions 

    bundle update

###### Best Practices
* When using a `Gemfile`, run commands with `bundle exec` prefixed. 
      
      bundle exec jekyll serve

  * This restricts your Ruby environment to **only use gems set in your Gemfile**.

#### If publishing your site with GitHub Pages,
**Note**:
- you can match production version of Jekyll by using the `github-pages` **gem** instead of `jekyll` in your `Gemfile`. 
- In this scenario you may also want to **exclude** `Gemfile.lock` from your repository 
because GitHub Pages ignores that file.

### 11.2. Plugins
`allow you to create custom generated content specific to your site`

###### three official plugins:
* `jekyll-sitemap` - Creates a sitemap file to help search engines index content 
* `jekyll-feed` - Creates an RSS feed for your posts 
* `jekyll-seo-tag` - Adds meta tags to help with SEO (Search Engine Optimization)

#### Jekyll Plugins usage

###### if using jekyll gem 
To use jekyll plugins, add them to `Gemfile`.

* If you put them in a `jekyll_plugins` **group** they’ll automatically be required into Jekyll:

`Gemfile`:
```
source 'https://rubygems.org'

gem "jekyll"

group :jekyll_plugins do
  gem "jekyll-sitemap"
  gem "jekyll-feed"
  gem "jekyll-seo-tag"
end
```

`_config.yml`:

```yaml
plugins:
  - jekyll-feed
  - jekyll-sitemap
  - jekyll-seo-tag
```


* Now install them

      bundle update

* For `jekyll-feed` and `jekyll-seo-tag` 

   * add tags to `_layouts/default.html`:
  
     ```html
          <!doctype html>
          <html>
            <head>
              <meta charset="utf-8">
              <title>{{ page.title }}</title>
              <link rel="stylesheet" href="/assets/css/styles.css">
              {% feed_meta %}
              {% seo %}
            </head>
            <body>
              {% include navigation.html %}
              {{ content }}
            </body>
          </html>
     ```

* `jekyll-sitemap` doesn’t need any setup, it creates sitemap on build
* Restart Jekyll server and check these tags are added to the `<head>`

###### if using github-pages gem
* The `github-pages` gem manages its own dependencies and includes specific versions of Jekyll and 
officially supported plugins. 

* As of now, `jekyll-sitemap`, `jekyll-feed`, and `jekyll-seo-tag` are part of the plugins GitHub Pages supports.

* Since they are bundled, there's no need to install or declare these plugins separately in `Gemfile`. 
* They only need to be configured in `_config.yml` to enable them.

---
Updated list of supported plugins/dependencies in GitHub Pages: 
[GitHub Pages Dependencies](https://pages.github.com/versions/)

---


### 11.3. Environments
**Environments**: used when you want to output something in production but not in development.

E.g.: Analytics scripts

###### Set the environment
by using the `JEKYLL_ENV` environment variable when running a command

e.g:

    JEKYLL_ENV=production bundle exec jekyll build

* By default `JEKYLL_ENV` is `development`. 
* The JEKYLL_ENV is available to you in **liquid** using `jekyll.environment`.

###### Example usecase
output the analytics script only on production
```html
{% if jekyll.environment == "production" %}
  <script src="my-analytics-script.js"></script>
{% endif %}
```

### 11.4. Deployment
* Run a production build:
    
      JEKYLL_ENV=production bundle exec jekyll build

* copy the contents of `_site` to your server 

Note:
* The contents of `_site` (destination folders) are automatically **cleaned**, by default, when the site is built. 
* Files or folders that are not created by your site's build process will be removed.

Retain files removed upon site builds:
* by specifying them within the `keep_files` **configuration** directive
* by keeping them in `assets` directory
* **better way**: automate the process using a CI or 3rd party


## 12. Integrate CSS Framework to Jekyll Site

`CSS`: Styles web pages and layouts by adjusting the appearance of HTML elements.

`SCSS`/`SASS`: A CSS preprocessor that adds variables, nested rules, and functions for more efficient styling.

`Tailwind`: A utility-first CSS framework with low-level classes for direct styling in HTML, 
offering flexibility but leading to verbose code.

`Bootstrap`: A front-end CSS framework with pre-styled components 
for building responsive, mobile-first websites quickly.


### 12.1. Using Bootstrap Template via CDN
Bootstrap provides following CDN links:
- `bootstrap.css`: compiled CSS file
- `bootstrap.js`: JS file
- `bootstrap.bundle.js`: JS file with Popper.js
- `bootstrap.min.css`: minified compiled CSS file
- `popper.min.js`: minified Popper.js
- `bootstrap.min.js`: minified JS file
- `bootstrap.bundle.min.js`: minified JS file with Popper.js
- `bootstrap.min.css.map` | `bootstrap.min.js.map` | `bootstrap.bundle.min.js.map`
  - used to facilitate debugging of minified CSS and JavaScript files
    by mapping the minified code back to the original source code
  - useful in development environments

bootstrap template: https://bootswatch.com/ : [Yeti](https://bootswatch.com/yeti/)

`/assets/css/styles.scss`
```scss
---
---
//@import "main";
```

`_includes/head.html`
```html
<head>
    .....

    <!-- Stylesheets -->
    <!-- ------------------------------------------------------------------------------------------------------->
    <!-- imports the Bootstrap library's styles into the webpage -->
  
    <!-- Bootswatch yeti bootstrap theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/cerulean/bootstrap.min.css">
  
    <!-- Bootstrap -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">-->
    <!-- <link rel="stylesheet" href="{{ '/assets/css/bootstrap.min.css' | relative_url }}"> -->
  
    <!-- custom CSS styles specific to the project:
    used alongside Bootstrap framework to provide additional customizations that are unique to the project -->
    <link rel="stylesheet" href="{{ '/assets/css/styles.css' | relative_url }}">
</head>
```

`_layouts/default.html`
```html
<!doctype html>
<html>
{% include head.html %}
<body>
.....
    <!-- Bootstrap JS and Popper.js CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
```

### 12.2. Enable toggling Site Color Mode between `dark` and `light`
`_includes/navigation.html`
```html
.....
                <!-- Toggle Theme/ Color Mode -->
                <li class="nav-item dropdown" data-bs-theme="light">
                    <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="theme-menu" aria-expanded="false" data-bs-toggle="dropdown" data-bs-display="static" aria-label="Toggle theme">
                        <i class="bi bi-circle-half"></i>
                        <span class="d-lg-none ms-2">Toggle theme</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li>
                            <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
                                <i class="bi bi-sun-fill"></i><span class="ms-2">Light</span>
                            </button>
                        </li>
                        <li>
                            <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="true">
                                <i class="bi bi-moon-stars-fill"></i><span class="ms-2">Dark</span>
                            </button>
                        </li>
                    </ul>
                </li>
.....
```

`_includes/default.html`
```html
<!doctype html>
<html lang="en" data-bs-theme="light">
.....
</html>
```

`_includes/head.html`
```html
<head>
  .....
    <!-- Scripts / JS Files -->
    <!-- Include the theme script -->
    <script src="{{ '/assets/js/theme.js' | relative_url }}"></script>
</head>
```

`/assets/js/theme.js`
```js
/*!
 * Color mode toggler for Bootstrap
 * This changes the color mode by changing the "data-bs-theme" attribute on the root <html> element.
 * If "data-bs-theme" attribute is set to specific value in any other html element (e.g nav-bar), it won't be affected.
 */
(() => {
    'use strict'

    const getStoredTheme = () => localStorage.getItem('theme')
    const setStoredTheme = theme => localStorage.setItem('theme', theme)

    const getPreferredTheme = () => {
        const storedTheme = getStoredTheme()
        if (storedTheme) {
            return storedTheme
        }

        return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
    }

    const setTheme = theme => {
        if (theme === 'auto') {
            document.documentElement.setAttribute('data-bs-theme', (window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'))
        } else {
            document.documentElement.setAttribute('data-bs-theme', theme)
        }
    }

    setTheme(getPreferredTheme())

    const showActiveTheme = (theme, focus = false) => {
        const themeSwitcher = document.querySelector('#bd-theme')

        if (!themeSwitcher) {
            return
        }

        const themeSwitcherText = document.querySelector('#bd-theme-text')
        const activeThemeIcon = document.querySelector('.theme-icon-active use')
        const btnToActive = document.querySelector(`[data-bs-theme-value="${theme}"]`)
        const svgOfActiveBtn = btnToActive.querySelector('svg use').getAttribute('href')

        document.querySelectorAll('[data-bs-theme-value]').forEach(element => {
            element.classList.remove('active')
            element.setAttribute('aria-pressed', 'false')
        })

        btnToActive.classList.add('active')
        btnToActive.setAttribute('aria-pressed', 'true')
        activeThemeIcon.setAttribute('href', svgOfActiveBtn)
        const themeSwitcherLabel = `${themeSwitcherText.textContent} (${btnToActive.dataset.bsThemeValue})`
        themeSwitcher.setAttribute('aria-label', themeSwitcherLabel)

        if (focus) {
            themeSwitcher.focus()
        }
    }

    window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
        const storedTheme = getStoredTheme()
        if (storedTheme !== 'light' && storedTheme !== 'dark') {
            setTheme(getPreferredTheme())
        }
    })

    window.addEventListener('DOMContentLoaded', () => {
        showActiveTheme(getPreferredTheme())

        document.querySelectorAll('[data-bs-theme-value]')
            .forEach(toggle => {
                toggle.addEventListener('click', () => {
                    const theme = toggle.getAttribute('data-bs-theme-value')
                    setStoredTheme(theme)
                    setTheme(theme)
                    showActiveTheme(theme, true)
                })
            })
    })
})()
```
- It is suggested to include the JavaScript to toggle theme/color mode **at the top of your page** 
to **reduce potential screen flickering** during reloading of your site. 

### 12.3. mixins

- programming technique used to add functionality to objects or classes
- enable code reuse and modularity
- commonly used in CSS preprocessors like `Sass` and `Less`

##### Note
* If you're using Bootstrap from a **CDN**, you won't have access to the **Bootstrap Sass mixins** 
because the **CDN** only provides the **compiled CSS**. 
* To use Bootstrap's Sass mixins, 
you need to include the Bootstrap Sass files directly in your project instead of using the CDN.


#### CSS mixins
- to define styles that can be reused throughout your stylesheet
- helps to keep CSS **DRY** (`Don't Repeat Yourself`)

```scss
@mixin border-radius($radius) {
  -webkit-border-radius: $radius;
     -moz-border-radius: $radius;
      -ms-border-radius: $radius;
          border-radius: $radius;
}

.button {
  @include border-radius(5px);
  background-color: blue;
  color: white;
  padding: 10px;
}
```

#### JavaScript Mixins
- to add properties and methods from one object to another
- useful for sharing behavior between classes without using inheritance

```js
const canFly = {
  fly() {
    console.log("Flying high!");
  }
};

const canSwim = {
  swim() {
    console.log("Swimming in the water!");
  }
};

class Animal {
  constructor(name) {
    this.name = name;
  }
}

Object.assign(Animal.prototype, canFly, canSwim);

const duck = new Animal("Duck");
duck.fly();  // Output: Flying high!
duck.swim(); // Output: Swimming in the water!
```


## 13. Monitor Usage

#### To save bandwidth when using GitHub Pages
* Regularly monitor bandwidth usage through the GitHub Pages settings to ensure you are within the limits.
* GitHub Pages has a soft bandwidth limit of 100 GB per month. 

`Github User Profile` -> `Settings` -> `Billing and plans` -> `Plans and usage` 
-> `Usage this month` -> `Git LFS Data`: `Bandwidth`

#### Alternatively, for more detailed analytics Google Analytics can be integrated

* Create a Google Analytics Account:
  * Go to Google Analytics and sign up for an account. 
  * Create a new property for your GitHub Pages site.
* Get the Tracking Code:
  * After creating the property, you will receive a tracking code (a JavaScript snippet). 
* Add the Tracking Code to GitHub Pages Site: `head.html`
```html
  <head>
    ....
    <!-- Google Analytics Tracking Code -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=YOUR_TRACKING_ID"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'YOUR_TRACKING_ID');
    </script>
  </head>
```
* Analyze Traffic:
  * You can log into your Google Analytics account to view detailed reports on traffic, 
  user behavior, and inferred bandwidth usage.

## 14. Markdown Processor & Code Blocks Styling / Highlighting

#### GitHub Pages supported Markdown Processors 

`kramdown`: default Markdown renderer for Jekyll
- options: `kramdown` | `GFM` | `Markdown` | `HTML`
  - `GFM`: https://github.com/kramdown/parser-gfm
  
        gem install  kramdown-parser-gfm

`GFM`: GitHub Flavored Markdown 
- GitHub's own Markdown processor used to render GFM throughout GitHub
- By default, Jekyll uses the GFM processor for Kramdown

options supported by Jekyll: `rouge`, `coderay`

#### Handling Liquid Tags in Code Blocks
* If you are using a language that contains curly braces,
  you will likely need to place `{% raw %}` and `{% endraw %}` tags around your code.
* Since Jekyll 4.0 , you can add `render_with_liquid: false` in front matter
  to **disable Liquid entirely** for a particular document.
* As of now, Github Pages uses Jekyll 3.10.0; to use `render_with_liquid` attribute in front matter 
you'd have to build and deploy github pages using custom workflow 
with github actions and newer gem set (e.g: jekyll 4.4.1 gem).

#### 14.1. Code Blocks Styling / Highlighting with `rouge`

     gem install rouge

`rouge` gem in `Gemfile`

`_config.yml`
```yaml
markdown_ext: markdown,mkdown,mkdn,mkd,md # markdown file extensions

# markdown processor/ markdown render engine settings
markdown: kramdown # markdown render engine - kramdown
kramdown: # kramdown settings
  input: GFM # markdown file input format
  hard_wrap: false # does not convert single line breaks into <br> tags
  auto_ids: true # automatically generates id attributes for headings
  entity_output: as_char # special characters are rendered in the generated HTML as characters (e.g., < as <).
  toc_levels: 1..6 # includes all heading levels from 1 to 6 in the table of contents
  smart_quotes: lsquo,rsquo,ldquo,rdquo # set smart quotes to be rendered as left and right single and double quotes
  gfm_quirks: # quirks for GitHub Flavored Markdown (GFM)
    - no_auto_typographic # disable automatic typographic replacements
    - paragraph_end # treat a newline as a paragraph break
  syntax_highlighter: rouge # syntax highlighter for code blocks
  syntax_highlighter_opts: # syntax highlighter options
    guess_lang: true # automatically detect the language of the code block
    css_class: "highlight" # CSS class for code blocks
```

##### Stylesheet for syntax highlighting
For `rouge` --> can use a [stylesheets for Pygments](https://github.com/jwarby/jekyll-pygments-themes)


##### To use without color mode changes
`assets/css/<STYLESHEET_NAME>.css`: download and add the stylesheet from https://jwarby.github.io/jekyll-pygments-themes/languages/ruby.html 


`assets/css/styles.scss`
```scss
.....
@import "<STYLESHEET_NAME>.css";
```

### 14.2. Enable color mode changes for Syntax Highlighting

`_sass/mixins/_color-mode.scss`: css mixin to switch css rules between color modes 
```scss
// scss-docs-start color-mode-mixin
@mixin color-mode($mode: light, $root: false) {
  // When this mixin is used, it will generate CSS rules for the specified color mode,
  // applying the styles provided in the @content block.
    [data-bs-theme="#{$mode}"] {
      @content;
    }
}
// scss-docs-end color-mode-mixin
```

`docs/_sass/_mixins.scss`: import mixins
```scss
@import "mixins/color-mode";
```

`_sass/_syntax-highlighting.scss`: syntax highlighting styles based on color mode
```scss
:root,
[data-bs-theme="light"] {
  .highlight {
    background-color: #f8f9f9 ;
    // styling for dark mode 
    // can use content from rouge default.css stylesheet
  }
}

@include color_mode(dark, true) {
  .highlight {
    background-color: #3e4451;
    // highlight styling for dark mode 
    // can use content from rouge native.css stylesheet
  }

}
```

`assets/css/styles.scss`: import syntax highlighting styles
```scss
.....
@import "mixins";
@import "syntax-highlighting";
```

### 14.3. Add copy to clipboard button to code blocks

`_sass/_clipboard-js.scss`: styling for [clipboard.js](https://clipboardjs.com/)

`_layouts/default.html`: include the bootstrap, clipboard.js, and copy-to-clipboard.js (a custom script) scripts in the layout
```html
<body>
    .....
  <!-- Bootstrap JS and Popper.js CDN -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <!-- Clipboard.js CDN -->
  <script src="https://cdn.jsdelivr.net/npm/clipboard@2.0.11/dist/clipboard.min.js"></script>
  <!-- Include the copy-to-clipboard script for code snippets-->
  <script src="{{ '/assets/js/copy-to-clipboard.js' | relative_url }}"></script>
</body>
```

`assets/js/copy-to-clipboard.js`: script to enable copying code snippets to the clipboard
```js
const btnTitle = 'Copy to clipboard'

const btnHtml = [
  '<div class="bd-code-snippet">',
  '  <div class="bd-clipboard">',
  '    <button type="button" class="btn-clipboard" title="Copy to clipboard">',
  '      <svg class="bi" role="img" aria-label="Copy"><use xlink:href="#clipboard"/></svg>',
  '    </button>',
  '  </div>',
  '</div>'
].join('')

document.querySelectorAll('div.highlighter-rouge')
    .forEach(element => {
      if (!element.closest('.bd-example-snippet')) { // Ignore examples made be shortcode
        element.insertAdjacentHTML('beforebegin', btnHtml)
        element.previousElementSibling.append(element)
      }
    })

document.querySelectorAll('[data-bs-toggle="tooltip"]')
    .forEach(tooltip => {
      new bootstrap.Tooltip(tooltip)
    })

document.querySelectorAll('.content [href="#"]')
    .forEach(link => {
      link.addEventListener('click', event => {
        event.preventDefault()
      })
    })

window.addEventListener('load', () => {
  document.querySelectorAll('.btn-clipboard').forEach(btn => {
    bootstrap.Tooltip.getOrCreateInstance(btn, {btnTitle})
  })
})

const clipboard = new ClipboardJS('.btn-clipboard', {
  target: trigger => trigger.closest('.bd-code-snippet').querySelector('.highlight'),
  text: trigger => trigger.closest('.bd-code-snippet').querySelector('.highlight').textContent.trimEnd()
})

clipboard.on('success', event => {
  const iconFirstChild = event.trigger.querySelector('.bi').firstElementChild
  const tooltipBtn = bootstrap.Tooltip.getInstance(event.trigger)
  const namespace = 'http://www.w3.org/1999/xlink'
  const originalXhref = iconFirstChild.getAttributeNS(namespace, 'href')
  const originalTitle = event.trigger.title

  tooltipBtn.setContent({'.tooltip-inner': 'Copied!'})
  event.trigger.addEventListener('hidden.bs.tooltip', () => {
    tooltipBtn.setContent({'.tooltip-inner': btnTitle})
  }, {once: true})
  event.clearSelection()
  iconFirstChild.setAttributeNS(namespace, 'href', originalXhref.replace('clipboard', 'check2'))

  setTimeout(() => {
    iconFirstChild.setAttributeNS(namespace, 'href', originalXhref)
    event.trigger.title = originalTitle
  }, 2000)
})

clipboard.on('error', event => {
  const modifierKey = /mac/i.test(navigator.userAgent) ? '\u2318' : 'Ctrl-'
  const fallbackMsg = `Press ${modifierKey}C to copy`
  const tooltipBtn = bootstrap.Tooltip.getInstance(event.trigger)

  tooltipBtn.setContent({'.tooltip-inner': fallbackMsg})
  event.trigger.addEventListener('hidden.bs.tooltip', () => {
    tooltipBtn.setContent({'.tooltip-inner': btnTitle})
  }, {once: true})
})

```

`_sass/mixins/_border-radius.scss` | `_sass/mixins/_breakpoints.scss`:
- [bootstrap mixins](https://github.com/twbs/bootstrap/tree/main/scss/mixins) required for `copy-to-clipboard.js`

`_sass/_mixins.scss`: import bootstrap mixins
```scss
.....
@import "mixins/border-radius";
@import "mixins/breakpoints";
```

`_sass/_variables.scss`: define variables required for the bootstrap mixins
```scss
// Variables required for Bootstrap mixins -----------------------
// Bootstrap default grid breakpoints
$grid-breakpoints: (
        xs: 0,
        sm: 576px,
        md: 768px,
        lg: 992px,
        xl: 1200px,
        xxl: 1400px
) !default;

// Enable the rounded border-radius utility
$enable-rounded: true !default;

// Border gutter spacing
$bd-gutter-x: 3rem;

// ----------------------------------------------------------------
```

`assets/css/styles.scss`: import the mixins, variables and clipboard-js styles
```scss
---
---
@import "variables";
@import "mixins";
@import "clipboard-js";
....
```

## 15. Github Actions to build and deploy Jekyll site with custom environment and gem versions

The default action workflow supports only [these](https://pages.github.com/versions/) dependencies.

If you need to use a different version of Jekyll or any other gem, you can create a custom workflow.

### 15.1. Prerequisites
Mention correct versions to be used in the `Gemfile`.

```ruby
# Gemfile

source "https://rubygems.org"

gem "jekyll", "~> 4.4.1"
gem "kramdown-parser-gfm", "~> 1.1.0"
gem "rouge", "~> 4.3.0"
```

### 15.2. Github Actions Workflow

**starter workflow** provided by GitHub Actions for Jekyll sites: [starter workflow for Github Pages](https://github.com/actions/starter-workflows/blob/main/pages/jekyll.yml)
- This action will be triggered on every push to the default branch and will expect Gemfile in the root directory.

**[Github Environment Protection Rules](https://docs.github.com/en/actions/managing-workflow-runs-and-deployments/managing-deployments/managing-environments-for-deployment#environment-protection-rules)**: 
limit which branches can deploy to an environment 
- When a job tries to deploy to an environment with Deployment branches configured
Actions will check the value of `github.ref` against the configuration and 
if it does not match the job will fail and the run will stop.
- Deployment branches rules 
  - All branches – Any branch in the repository can deploy 
  - Protected branches – Only branches with protection rules 
  - Selected branches – Branches matching a set of name patterns

**[Github Branch Protection Rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/managing-a-branch-protection-rule#about-branch-protection-rules)**

preset actions: [actions](https://github.com/actions)

workflow file location in repo: `.github/workflows/jekyll.yml`

#### Setting up the Action

git repo -> `Settings` -> `Pages` -> `Build and deployment` -> `Source` 
- change to `GitHub Actions` (previously set to **"Deploy from a branch"**)

git repo -> `Actions` -> `New workflow` -> search for `Jekyll` -> 
- `Configure` under `Jekyll workflow` (**not** _GitHub Pages Jekyll_ workflow )
  - Review the changes
    - specially if you are deploying from a subdirectory, 
    then **jekyll build command options** and **config file path** should be updated
    ```yaml
      # Sample workflow for building and deploying a Jekyll site to GitHub Pages
      name: Deploy Jekyll Tryouts site to Pages
    
      on:
        # Runs on pushes targeting the default branch
        push:
          branches: ["main"]
    
        # Allows you to run this workflow manually from the Actions tab
        workflow_dispatch:
    
      # Sets permissions of the GITHUB_TOKEN to allow deployment to GitHub Pages
      permissions:
        contents: read
        pages: write
        id-token: write
    
      # Allow only one concurrent deployment, skipping runs queued between the run in-progress and latest queued.
      # However, do NOT cancel in-progress runs as we want to allow these production deployments to complete.
      concurrency:
        group: "pages"
        cancel-in-progress: false
    
      jobs:
        # Build job
        build:
          runs-on: ubuntu-latest
          steps:
            - name: Checkout
              uses: actions/checkout@v4
              # clone the repository to the runner
              # making all of the repository files available for the following steps in the workflow
            - name: Setup Ruby
              # https://github.com/ruby/setup-ruby/releases/tag/v1.207.0
              uses: ruby/setup-ruby@4a9ddd6f338a97768b8006bf671dfbad383215f4
              with:
                ruby-version: '3.1' # Not needed with a .ruby-version file
                bundler-cache: true # runs 'bundle install' and caches installed gems automatically
                cache-version: 0 # Increment this number if you need to re-download cached gems
            - name: Setup Pages
              # https://github.com/actions/configure-pages/blob/main/action.yml
              id: pages
              uses: actions/configure-pages@v5
            - name: Setup dependencies
              run: |
                cd docs  # Navigate to the subdirectory containing the Jekyll site
                bundle install
            - name: Build with Jekyll
              # Outputs to the './_site' directory by default
              run: |
                cd docs # Navigate to the subdirectory containing the Jekyll site
                bundle exec jekyll build --baseurl "${{ steps.pages.outputs.base_path }}"
              env:
                JEKYLL_ENV: production
            - name: Upload artifact
              # Automatically uploads an artifact from the './_site' directory by default
              uses: actions/upload-pages-artifact@v3
              with:
                path: 'docs/_site'
      
        # Deployment job
        deploy:
          environment:
            name: github-pages
            url: ${{ steps.deployment.outputs.page_url }}
          runs-on: ubuntu-latest
          needs: build
          steps:
            - name: Deploy to GitHub Pages
              id: deployment
              uses: actions/deploy-pages@v4
    ```
  
- `Commit changes`


#### Build and Deploy

git repo -> `Actions` -> `Deployments` -> view live site via deployed site URL


### 15.3. Workflow Management
`Caching` — The `ruby/setup-ruby` action makes it possible to cache installed gems automatically 
instead of having to download the bundle on each build.

## 16. Add Table of Content for `.md` files

Enable using `https://github.com/allejo/jekyll-toc`
- This template does not allow skipping heading levels in the table of contents.
  - For example, you cannot jump from Heading 2 directly to Heading 5.
- TOC is generated based on <h1> to <h6> headings in the markdown content

`_includes/toc.html`: from `https://github.com/allejo/jekyll-toc/blob/master/_includes/toc.html`

usage: in the layout where `{{content}}` is rendered
```html
{% include toc.html html=content h_min=1 h_max=8 item_class="nav-item" anchor_class="nav-link" %}
```
- html: the HTML of compiled markdown (generated by kramdown in Jekyll)
- sanitize: if true, headers will be stripped of any HTML in the TOC
- class: CSS class assigned to the TOC 
- id: ID to assigned to the TOC 
- h_min: minimum TOC header level to use 
- h_max: maximum TOC header level to use 
- ordered: if true, an ordered list will be outputted instead of an unordered list
- item_class: class(es) for each list item <li></li>
- submenu_class (string): class(es) for each child group of headings 
- base_url: the base url needed when TOC links content on another page than the actual content 
- anchor_class: class(es) for each anchor element <a></a>
- skip_no_ids: if true, skip headers that do not have an `id` attribute
- flat_toc: if true, the TOC will be a single level list

`_sass/_toc.scss`: styles for the table of contents
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/site/assets/scss/_toc.scss

`_sass/_layout.scss`: styles for the layout with TOC
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/site/assets/scss/_layout.scss

`_sass/vendor/_rfs.scss`: styles for responsive font sizes
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/scss/vendor/_rfs.scss

`_sass/_mixins.scss`: import RFS mixins
```scss
.....
@import "vendor/rfs";
```

`_sass/_variables.scss`: define variables for the layout and anchor links
```scss
  .....
  // Grid gutter width
  $grid-gutter-width: 1.5rem;
  
  // Links
  //
  // Style anchor elements.
  
  $link-color:                              $primary !default;
  $link-decoration:                         underline !default;
  $link-hover-decoration:                   null !default;
```
- it's important to use the `_variables.scss` for the theme you are using and 
append additional variables required for the TOC 

`assets/css/styles.scss`: import the stylesheets
```scss
.....
  @import "layout";
  @import "vendor/rfs";
  @import "toc";
```

## 17. Add Anchors to Headings

Using [Anchor.js](https://www.bryanbraun.com/anchorjs/)

`_includes/scripts.html`: include the anchor.js script
```html
<!-- Anchor.js CDN to add anchor links to headings: https://www.bryanbraun.com/anchorjs/ -->
<script src="https://cdn.jsdelivr.net/npm/anchor-js/anchor.min.js"></script>
<script>
    anchors.add(); <!-- Add anchors before the closing body tag. -->
</script>
```

## 18. Enable Scrollable TOC that automatically highlights the current section 

Using Bootstrap's Scrollspy component
- Scrollspy is a JavaScript plugin that automatically updates navigation components based on scroll position 
to indicate which link is currently active in the viewport.
- CDN for Bootstrap's JS file should be included as a script

`_layouts/doc.html`: usage in layout with TOC
```html
....
<!-- Table of Content -->
<div class="bd-toc mt-3 mb-5 my-lg-0 mb-lg-5 px-sm-1 text-body-secondary">
  <button class="btn btn-link p-md-0 mb-2 mb-md-0 text-decoration-none bd-toc-toggle d-md-none" type="button" data-bs-toggle="collapse" data-bs-target="#tocContents" aria-expanded="false" aria-controls="tocContents">
    On this page
    <svg class="bi d-md-none ms-2" aria-hidden="true"><use xlink:href="#chevron-expand"></use></svg>
  </button>
  <strong class="d-none d-md-block h6 my-2 ms-3">On this page</strong>
  <hr class="d-none d-md-block my-2 ms-3">
  <div class="collapse bd-toc-collapse" id="tocContents">
    <nav id="TableOfContents">
      {% include toc.html html=content h_min=1 h_max=8 item_class="nav-item" anchor_class="nav-link" %}
    </nav>
  </div>
</div>

<div class="bd-content ps-lg-2" {% if page.toc == true %} data-bs-spy="scroll" data-bs-target="#TableOfContents" tabindex="0" {% endif %}>
  {{ content }}
</div>
```

`_sass/_scrolling.scss`: to prevent focus from landing behind the sticky header, when navigating with the keyboard
- specially useful when using navigation bars that stick to the top

`assets/css/styles.scss`: import the scrolling styles
```scss
.....
@import "scrolling";
```

`_config.yml`: to avoid CSS selectors having a digit as the first character; 
since query selector in scrollspy.js throws a syntax error, if generated IDs for headings start with a digit
```yaml
.......
markdown: kramdown 
kramdown: 
  input: GFM 
  hard_wrap: false 
  auto_ids: true 
  auto_id_prefix: "id-" # prefix for automatically generated id attributes
    # Kramdown does not strip preceding numbers from generated header IDs when GFM is used as the input format.
    # query selector in scrollspy.js throws a syntax error, if generated IDs start with a digit
    #     as CSS selectors cannot start with a digit.
    # To avoid this, we can set auto_id_prefix to "id-" to ensure that all generated IDs start with a letter.
.....
```

## 19. Reuse cached files instead of rendering each time

Using `jekyll-include-cache` plugin and `include_cached` liquid tag to cache the output of included files

### 19.1. Usage

* add `jekyll-include-cache` plugin to `Gemfile`

      gem install jekyll-include-cache

* `Gemfile`

      gem "jekyll-include-cache"

* Update Jekyll `_config.yml` to include the plugin
  ```yaml
  plugins:
    - jekyll-include-cache
  ```

* Can be used with `include_cached` liquid tag
  ```markdown
  ---
  layout: default
  title: "Jekyll Guide"
  ---

  {% include_cached navigation.html %}
  ```


### 19.2. `include` vs `include_cached` tags
- `{% include %}` tag: renders the included file every time it appears in the layout or page
- `{% include_cached %}` tag: caches the output of the included file based on its parameters and filename
  - If the same include is used multiple times with identical parameters,
    it is rendered only once and then reused from cache.
- Jekyll's `include` and `include_cached` tags are restricted to files within the `_includes` directory.

## 20. 404 Not Found Page

`404.html`: custom 404 page at root directory of the github pages publishing directory

### Note:
- For this to work permalink should be set to `pretty` in `_config.yml`
  `_config.yml`
```yaml
permalink: pretty
```
