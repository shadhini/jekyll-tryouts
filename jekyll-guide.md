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


structure to keep assets organized:
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

* Directly under the root create another folder called `_sass`
* Can use standard CSS files for styling.


* **Inlining** the styles used in `_includes/navigation.html` is **not a best practice**.


* Create a Sass file at `assets/css/styles.scss` with the following content:
  ```scss
  
  ---
  ---
  // Empty front matter at the top:  tells Jekyll it needs to process the file.
  @import "main";
  // @import "main": tells Sass to look for a file called main.scss in the sass directory (_sass/) by default
    ```
  
* Create a Sass file at `_sass/main.scss` with the following content:
  ```scss
  // Create a class named "current" in order to color the current link green. 
  .current {
  color: green;
  }
  ```                                                                                                              

* To reference the stylesheet in your layout , open `_layouts/default.html` and add the stylesheet to the `<head>`:

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
   * The `styles.css` referenced here is generated by Jekyll from the `styles.scss` you created earlier in `assets/css/.`


* Now refer to the class from within the `navigation.html`
```html
<nav>
  {% for item in site.data.navigation %}
    <a href="{{ item.link }}" {% if page.url == item.link %}class="current"{% endif %}>{{ item.name }}</a>
  {% endfor %}
</nav>
```

Load up http://localhost:4000 

## 8. Blogging
`Blog without a database.`
In Jekyll style, blogging is powered by **text files only**.

### 8.1. Posts
Blog posts live in a folder called `_posts`.

Filename format for posts: [PUBLISH_DATE_YYYY:MM:DD]-[TITLE].[EXTENSION]

Create a post at `_posts/2025-02-10-blog1-file-name.md` with the following content:

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
- The `post` **layout** doesn’t exist so you’ll need to create it at `_layouts/post.html `with the following content:

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

### 8.2. List posts
Typically a blog has a page which lists all the posts.

Jekyll makes posts available at `site.posts`.

Create `blogs.html` in your root (/blogs.html) with the following content:

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

Open `_data/navigation.yml` and add an entry for the blogs page:

```yml
- name: Home
  link: /
- name: About
  link: /about.html
- name: Blog
  link: /blogs.html
```

Add few more posts and open http://localhost:4000 
