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
# front matter defaults: set a layout for all items in a collection
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

