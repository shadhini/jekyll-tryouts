---
render_with_liquid: false
---
# Jekyll Guide

`Jekyll – static site generator`
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


