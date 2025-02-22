# About jekyll

## input files: 
* `.md`, `.html`, `.yml`, `.json`
* templates/tags in `liquid` --> `{{ }}`, `{% %}`
* css/js/assets

## configuration file: 
`_config.yml`

## build process:
1. parse `.md` files and `liquid` templates
2. convert `.md` to `.html`
3. apply templates from `_layouts`
4. generate navigation or dynamic content 
   * e.g: `{% for item in site.posts %}`
5. combine all parts into static **HTML** files

## output files:
`_site` folder

## deployment:

`Gemfile` – for dependency management
- installing a new gem (adding to gem file): `gem install <GEM_NAME>`

`Bundler` – manages Ruby gem dependencies
- `bundle install` | `bundle` – installs all gems in the `Gemfile`
- `bundle exec jekyll serve` – runs Jekyll with the gems in the `Gemfile`

if publishing site with GitHub Pages,
- match production version of Jekyll by using the `github-pages` **gem** instead of `jekyll` in your `Gemfile`
- **exclude** `Gemfile.lock` from repository as GitHub Pages ignores that file

## notes:
Jekyll converts markdown files to html files using following methods.
 * **layouts**, 
 * `{{content}}` attribute and 
 * `mardownify` filter 

**Front Matter** should be included in a file to **process liquid tags** in it. Also, it is used 
* to specify configuration details such as `layout` at the individual file level
* to set custom properties for individual page/content

# Testing Jekyll on GH Pages locally with live reload

from the root directory for ph pages
```bash
cd docs
bundle exec jekyll serve --livereload
```

# Configuration
jekyll configuration file: `_config.yml`
```yaml
# Base URL: if your site is hosted at https://username.github.io/repository-name
baseurl: "/jekyll-tryouts"

markdown_ext: markdown,mkdown,mkdn,mkd,md # markdown file extensions to process
# default = markdown,mkdown,mkdn,mkd,md

# Markdown processor/ markdown render engine settings for the site
markdown: kramdown # markdown render engine - kramdown 
  # Site can be built locally using Jekyll only with kramdown as markdown processor
kramdown: # kramdown settings https://kramdown.gettalong.org/documentation.html
  input: GFM # markdown file input format to the kramdown processor
    # values for the input attribute:
      #  GFM - GitHub Flavored Markdown
        # dependencies: 
          # kramdown-parser-gfm gem
          # https://github.com/kramdown/parser-gfm
      #  Kramdown - Kramdown's default markdown format
      #  Markdown - Standard Markdown
      #  HTML - HTML input
      #  KramdownParserGFM - Kramdown's GFM parser
  hard_wrap: false # does not convert single line breaks into <br> tags
  auto_ids: true # Kramdown automatically generates id attributes for headings 
     # which are useful for creating anchor links to specific sections of the document
  footnote_nr: 1 # set the starting number for footnotes in your document; default = 1
    # useful if you need to continue footnote numbering from a previous document or 
    # if you have specific formatting requirements
  entity_output: as_char # how HTML entities are output in the generated HTML; default = Kramdown converts special characters to HTML entities
    # values for the entity_output attribute:
      #  :as_char - Output special characters as characters (e.g., < as <).
      #  :as_name - Output special characters as named entities (e.g., < as &lt;).
      #  :as_decimal - Output special characters as decimal entities (e.g., < as &#60;).
      #  :as_hex - Output special characters as hexadecimal entities (e.g., < as &#x3C;)
  toc_levels: 1..6 # set the range of heading levels to include in the table of contents
    # default = 1..6, which includes all heading levels from 1 to 6
  smart_quotes: lsquo,rsquo,ldquo,rdquo # allows to specify custom characters for opening and closing single and double quotation marks
    # values for the smart_quotes attribute:
      #  :lsquo - Left single quote (‘)
      #  :rsquo - Right single quote (’)
      #  :ldquo - Left double quote (“)
      #  :rdquo - Right double quote (”)
  syntax_highlighter: rouge # syntax highlighter for code blocks; default = rouge
    # values for the syntax_highlighter attribute:
      #  :rouge - Use the Rouge syntax highlighter
        # dependency: rouge gem
        # stylesheet: https://jwarby.github.io/jekyll-pygments-themes/languages/ruby.html
      #  :coderay - Use the Coderay syntax highlighter
      #  :pygments - Use the Pygments syntax highlighter
    # kramdown supported syntax highlighters: rouge, coderay
  syntax_highlighter_opts: # set options for the syntax highlighter
    css_class: highlight2 # set the CSS class for code blocks
      # e.g: <pre class="highlight2"><code>...</code></pre>
      # [work with rouge]
    span: false # wrap each line of code in a span element
    line_numbers: true # display line numbers in code blocks
      # [work with rouge]
    line_number_start: 1 # set the starting line number for code blocks
    line_number_anchors: true # add anchor links to line numbers
      # [do not work with rouge] 
    guess_lang: true # attempt to guess the language of code blocks
      # [work with rouge]
    block_tabs: 2 # set the number of spaces to use for tab characters
    block_start: "<div>" # set the starting tag for code blocks
    block_end: "</div>" # set the ending tag for code blocks
    block_title: "Code" # set the title for code blocks
    block_lang: "plaintext" # set the default language for code blocks
    block_opts: # set default options for code blocks
      line_numbers: true # display line numbers in code blocks
      line_number_start: 1 # set the starting line number for code blocks
      line_number_anchors: true # add anchor links to line numbers
      block_tabs: 2 # set the number of spaces to use for tab characters
      block_start: "<div>" # set the starting tag for code blocks
      block_end: "</div>" # set the ending tag for code blocks
      block_title: "Code" # set the title for code blocks
      block_lang: "plaintext" # set the default language for code blocks
  enable_coderay: false # disable coderay syntax highlighting for code blocks
  # if enable_coderay: true, then specify the coderay settings as follows
  #  coderay:
  #      coderay_wrap: div # wrap code blocks in a div element
  #      coderay_line_numbers: inline # display line numbers inline with the code
  #      coderay_line_numbers_start: 1 # set the starting line number for code blocks
  #      coderay_tab_width: 4 # set the number of spaces to use for tab characters
  #      coderay_bold_every: 10 # bold every 10th line number in code blocks
  #      coderay_css: style # specify the CSS style for code blocks
  #      coderay_default_lang: ruby # set the default language for code blocks
  #      coderay_default_options: # set default options for code blocks
  #      line_numbers: table # display line numbers in a table
  #      line_number_anchors: true # add anchor links to line numbers
  #      bold_every: 10 # bold every 10th line number
  #      tab_width: 4 # set the number of spaces to use for tab characters
  #      css: style # specify the CSS style for code blocks
  gfm_quirks: # quirks for GitHub Flavored Markdown (GFM)
    # allows you to enable or disable specific quirks when using GitHub Flavored Markdown (GFM)
    # quirks can help you fine-tune how certain Markdown features behave to better match GitHub's rendering
    - no_auto_typographic # disable automatic typographic replacements (e.g., smart quotes, ellipses, dashes)
    - paragraph_end # allows paragraphs to end without a newline
    - no_automatic_links # Disables automatic linking of URLs
    - no_emphasis_underscore # Disables emphasis for underscores within words
  math_engine: mathjax # set the math engine for rendering math equations
    # values for the math_engine attribute:
      #  :mathjax - Use the MathJax math engine
      #  :itex - Use the iTeX math engine

  
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

# Directory Structure

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

# Site Variables
<!-- TODO: site variables -->

# Layouts
* no front matter
* layouts can inherit from another layout when front matter included

# Collections
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


# Filters

* `markdownify`: convert Markdown-formatted text into HTML
  * when `{{ content }}` is used in a layout, it is automatically converted

## where filter
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

## connected multiple filters
e.g:
```html
{% assign author = site.authors | where: 'short_name', page.author | first %}
{% if author %}
- <a href="{{ author.url }}">{{ author.name }}</a>
{% endif %}
```

# Site Assets & Styling
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

# Navigation
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

# Plugins:
* `jekyll-sitemap` - Creates a sitemap file to help search engines index content
* `jekyll-feed` - Creates an RSS feed for your posts
* `jekyll-seo-tag` - Adds meta tags to help with SEO (Search Engine Optimization)

## if using `jekyll` gem in Gemfile

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

## if using `github-pages` gem in Gemfile
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

# Environments

liquid var: `jekyll.environment`

    JEKYLL_ENV=production bundle exec jekyll build


# Deployment
Retain files removed upon site builds:
* by specifying them within the `keep_files` **configuration** directive
* by keeping them in `assets` directory
* **better way**: automate the process using a CI or 3rd party

# Monitor Bandwidth Usage

## With Github Billing Details
`Github User Profile` -> `Settings` -> `Billing and plans` -> `Plans and usage`
-> `Usage this month` -> `Git LFS Data`: `Bandwidth`

## With Google Analytics Account
* create account, create property for the site and obtain `tracking code`
* add the `tracking code` to the site layout head 
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
* view usage details via Google Analytics Account

# Integrating CSS Framework

## Using Bootswatch Yeti Bootstrap Template via CDN

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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/yeti/bootstrap.min.css">
  
    <!-- custom CSS styles specific to the project:
    used alongside Bootstrap framework to provide additional customizations that are unique to the project -->
    <link rel="stylesheet" href="{{ '/assets/css/styles.css' | relative_url }}">

    <!-- Scripts / JS Files -->
    <!-- Include the theme script -->
    <script src="{{ '/assets/js/theme.js' | relative_url }}"></script>
</head>
```
- The script to toggle the theme/color mode is included **at the top of the page** 
to **reduce potential screen flickering** during reloading of the site.

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

## Other CSS styles related files

`assets/js/`
- `theme.js`: JS script for enabling switching between **_dark_** and **_light_** site color themes/modes

`_includes/footer.html`
- web page footer


---

# Markdown Processor
options: `kramdown` | `GFM` | `Markdown` | `HTML`

`kramdown`: https://kramdown.gettalong.org/documentation.html
- default markdown processor for Jekyll
- only kramdown can be locally built with Jekyll

`GFM`: GitHub Flavored Markdown

# Style Code Blocks with Markdown Processor

syntax highlighters supported by Jekyll: `rouge`, `coderay`

#### Handling Liquid Tags in Code Blocks
If you are using a language that contains curly braces,
* wrap the code block that contains `{%` and `%}` with  
  `{% raw %}` and `{% endraw %}` tags.
* From Jekyll 4.0, 
  * add `render_with_liquid: false` in front matter
    to **disable Liquid entirely** for a particular document

## If using Rouge Syntax Highlighter
dependency: `rouge` gem

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
    line_numbers: true # display line numbers in code blocks
```

stylesheets: [stylesheets for Pygments](https://github.com/jwarby/jekyll-pygments-themes)

`_sass/mixins/_color-mode.scss`: css mixin to switch css rules between color modes

`docs/_sass/_mixins.scss`: import mixins
```scss
@import "mixins/color-mode";
```
`_sass/_syntax-highlighting.scss`: syntax highlighting styles based on color mode

`assets/css/styles.scss`: import syntax highlighting styles
```scss
.....
@import "mixins";
@import "syntax-highlighting";
```

# Reusable Templates

- `_includes/navigation.html`
- `_includes/footer.html`
- `_includes/head.html`
- `_layouts/default.html`

## Technology Catalog
main page: `tech-catlog.html`

`_data`
- `navigation.yml`
  ```yaml
  #.....
  - name: "Tech Catalog"
    link: /tech-catalog.html
  ```
- `technologies.yml`: list of topics for each technology
- `topics.yml`: list of technologies for each topic

`_layouts`
- `technology.html`
- `topic.html`

`_technologies`: `.md` / `.html` per each technology
- [e.g:] `bootstrap.md`
- [e.g:] `tailwind-css.md`

`_topics`: `.md` / `.html` per each topic
- [e.g] `css-frameworks.html`
- [e.g] `web-development-technologies.html`

`_config.yml`
  ```yaml
  collections:
    # .....
    technologies:
      output: true
    topics:
      output: true
  
  defaults:
    # .....
    - scope:
        path: ""
        type: "technologies"
      values:
        layout: "technology"
    - scope:
        path: ""
        type: "topics"
      values:
        layout: "topic"
  
  ```

## Landing Page layout with Image

`_layouts/landing-page.html`: landing page layout

`_sass/_custom.scss`: custom styles for cover page
  ```scss
  // custom cover page styles
  .cover-page-container {
    width: 100%;
    overflow: hidden;
    max-width: 100%;
  }
  .cover-page-container img {
    width: 100%;
    height: auto;
    display: block;
    max-width: 100%;
  }
  ```

`assets/css/styles.scss`
  ```scss
  ---
  ---
  @import "custom";
  ```

`assets/images/landing-page-cover-image.png`: landing page image

`index.md`: reference the landing-page layout
  ```markdown
  ---
  ....
  layout: landing-page
  ---
  ```

