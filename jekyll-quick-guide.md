## About jekyll

###### input files: 
* `.md`, `.html`, `.yml`, `.json`
* templates/tags in `liquid` --> `{{ }}`, `{% %}`
* css/js/assets

###### configuration file: 
`_config.yml`

###### build process:
1. parse `.md` files and `liquid` templates
2. convert `.md` to `.html`
3. apply templates from `_layouts`
4. generate navigation or dynamic content 
   * e.g: `{% for item in site.posts %}`
5. combine all parts into static **HTML** files

###### output files:
`_site` folder

###### deployment:

`Gemfile` – for dependency management
`Bundler` – manages Ruby gem dependencies

if publishing site with GitHub Pages,
- match production version of Jekyll by using the `github-pages` **gem** instead of `jekyll` in your `Gemfile`
- **exclude** `Gemfile.lock` from repository as GitHub Pages ignores that file

###### notes:
Jekyll converts markdown files to html files using following methods.
 * **layouts**, 
 * `{{content}}` attribute and 
 * `mardownify` filter 

**Front Matter** should be included in a file to **process liquid tags** in it. Also, it is used 
* to specify configuration details such as `layout` at the individual file level
* to set custom properties for individual page/content

## Testing Jekyll on GH Pages locally with live reload

from the root directory for ph pages
```bash
cd docs
jekyll serve --livereload
```

## Configuration
jekyll configuration file: `_config.yml`
```yaml
# Base URL: if your site is hosted at https://username.github.io/repository-name
baseurl: "/jekyll-tryouts"
# enable document/item output for collections
collections:
  authors:
    output: true
# front matter defaults: can be used to set property values for all items/pages in a matching path 
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
  - scope:
      path: "projects"
      type: "pages" 
    values:
      layout: "project" # overrides previous default layout
      author: "Mr. Hyde"
```

* Whenever `_config.yml` file is updated, you'd have to restart Jekyll for the changes to take effect.

## Directory Structure

```text
|-- docs: root gh pages publishing directory
    |-- _config.yml: configuration file
    |-- _layouts: page layouts
    |-- _includes: reusable code snippets
    |-- _posts: blog posts
        * site.posts
        * post.url
        * post.title: post filename or front matter title
        * post.excerpt: first para of content
    |-- _data: data files
        * site.data
    |-- _sass: sass files
    |-- _<COLLECTION_NAME>: sample collection; there can be any number of collections
        * site.<COLLECTION_NAME>
    |-- assets: site assets
        |-- css
            |-- styles.scss: entry point for the website’s CSS
        |-- js
        |-- images
    |-- index.html/index.md
    |-- about.html/about.md
    |-- contact.html/contact.md
    |-- blogs.html: blogs (taken from /_posts) list view 
```
## Site Variables


## Layouts
* no front matter
* layouts can inherit from another layout

## Collections
for each collection
--> there is a directory named `_<COLLECTION_NAME>` at root directory for gh pages

collection items can be accessed with: `site.<COLLECTION_NAME>` variable

- collection list page: `.html`
- entry for the collection list page: `_data/navigation.yml`
- collection items/documents: @ `_<COLLECTION_NAME>` directory 
- enable pages for each collection item in `_config.yaml`
  ```yaml
  # enable document/item output for collections
  collections:
    authors:
      output: true
  ```
- layout for items/individual documents: `_layouts/<COLLECTION_ITEM_COMMON_NAME>.html`
- 


## Filters

* `markdownify`: convert Markdown-formatted text into HTML
  * when `{{ content }}` is used in a layout, it is automatically converted

##### where filter
```js
collection | where: 'key', value
```
- **`key`**: The front matter property to filter by
- **`value`**: The target value to match against; 

e.g:
```html
{% assign filtered_posts = site.posts | where: 'author', page.short_name %}
```
* loops through `site.posts` and keeps only those posts 
  * where the `author` front matter in each post matches the value of `page.short_name`

##### connected multiple filters
e.g:
```html
{% assign author = site.authors | where: 'short_name', page.author | first %}
{% if author %}
- <a href="{{ author.url }}">{{ author.name }}</a>
{% endif %}
```

## Site Assets & Styling
assets location: `assets`
- `assets/css/style.scss`
    ```scss
    ---
    ---
    @import "main"; // load styles from _sass/main.scss
     ```
- `assets/js/`
- `assets/images/`

sass location: `_sass/`
- `_sass/main.scss`

assets runtime location: `_site/assets/`

stylesheet url: `assets/css/style.css`

layout that uses stylesheet:
```html
<!doctype html>
<html>
<head>
    .....
    <!-- link to the style sheet: better to use relative_url filter 
    to ensure Jekyll automatically resolves the path for the `baseurl` you have set properly-->
    <link rel="stylesheet" href="{{ '/assets/css/styles.css' | relative_url }}"> 
</head>
.....
</html>
```

## Navigation
at `_includes/navigation.html`
- as part of template to be included in the layout file

-     site.data.navigation

data file: `_data/navigation.yml`
```yaml
- name: Home
  link: /
- name: About
  link: /about.html
```

## Plugins:
* `jekyll-sitemap` - Creates a sitemap file to help search engines index content
* `jekyll-feed` - Creates an RSS feed for your posts
* `jekyll-seo-tag` - Adds meta tags to help with SEO (Search Engine Optimization)

###### if using `jekyll` gem in Gemfile

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
- putting plugins on `jekyll_plugins` group, make them automatically be required into Jekyll

`_config.yml`:

```yaml
plugins:
  - jekyll-feed
  - jekyll-sitemap
  - jekyll-seo-tag
```

command to install plugins:
    
    bundle update

For `jekyll-feed` and `jekyll-seo-tag` 
* `_layouts/default.html`
    ```html
    <!doctype html>
    <html>
    <head>
      .....
      {% feed_meta %}
      {% seo %}
    </head>
    .....
    </html>
    ```

###### if using `github-pages` gem in Gemfile
* `jekyll-sitemap`, `jekyll-feed`, and `jekyll-seo-tag` plugins are supported natively and 
bundled with the `github-pages` gem. So there's no need to manually include them in `Gemfile`.

`_config.yml`:

```yaml
plugins:
  - jekyll-feed
  - jekyll-sitemap
  - jekyll-seo-tag
```

For `jekyll-feed` and `jekyll-seo-tag`
* `_layouts/default.html`
    ```html
    <!doctype html>
    <html>
    <head>
      .....
      {% feed_meta %}
      {% seo %}
    </head>
    .....
    </html>
    ```

## Environments

liquid var: `jekyll.environment`

    JEKYLL_ENV=production bundle exec jekyll build


## Deployment
Retain files removed upon site builds:
* by specifying them within the `keep_files` **configuration** directive
* by keeping them in `assets` directory
* **better way**: automate the process using a CI or 3rd party

## Integrating CSS Framework

#### Using Bootswatch Yeti Bootstrap Template via CDN

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
    <!-- Bootswatch yeti bootstrap theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/cerulean/bootstrap.min.css">
  
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


