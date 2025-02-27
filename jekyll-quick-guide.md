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
kramdown: # kramdown settings 
  # Doc: https://kramdown.gettalong.org/documentation.html
  # Configuration options: https://kramdown.gettalong.org/options.html
  input: GFM # markdown file input format to the kramdown processor
    # Doc: https://kramdown.gettalong.org/parser/gfm.html
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
  auto_id_prefix: "id-" # prefix for automatically generated id attributes
    # Kramdown does not strip preceding numbers from generated header IDs when GFM is used as the input format.
    # query selector in scrollspy.js throws a syntax error, if generated IDs start with a digit 
    #     as CSS selectors cannot start with a digit.
    # To avoid this, we can set auto_id_prefix to "id-" to ensure that all generated IDs start with a letter.
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
    # Doc: https://kramdown.gettalong.org/syntax_highlighter
    # values for the syntax_highlighter attribute:
      #  :rouge - Use the Rouge syntax highlighter
        # dependency: rouge gem
        # stylesheet: https://jwarby.github.io/jekyll-pygments-themes/languages/ruby.html
        # Doc: https://kramdown.gettalong.org/syntax_highlighter/rouge.html
      #  :coderay - Use the Coderay syntax highlighter
        # Doc: https://kramdown.gettalong.org/syntax_highlighter/coderay.html
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
  enable_coderay: false # disable coderay syntax highlighting for code blocks
  # if enable_coderay: true, then specify the coderay settings as follows
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

permalink: /:slugified_categories/:slug/ # slugified document's filename with slugified categories
  #   (any character except numbers and letters is replaced as hyphen)
  # if permalink: pretty, then the URLs will be in the format:
        # /:categories/:year/:month/:day/:title/ for posts
        # /:categories/:title/ for pages
  
# enable document/item output for collections
collections:
  technologies:
    output: true
    permalink: /:collection/:name/ 
    # URL with collection label and 
    #   document's base filename slugified: downcased and 
    #   every sequence of non-alphanumeric character (including spaces) replaced by a hyphen.
  topics:
    output: true
    permalink: /:collection/:name/
    
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
      show_sidebar: true # this property is accessible via page.show_sidebar at every page 
      # unless it is overridden at the page level front matter
      toc: true
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

## Using Bootstrap via CDN
Bootstrap provides following CDN links:
- `bootstrap.css`: compiled CSS file
- `bootstrap.js`: JS file
- `bootstrap.bundle.js`: JS file with Popper.js
- `bootstrap.min.css`: minified compiled CSS file
- `bootstrap.min.js`: minified JS file
- `bootstrap.bundle.min.js`: minified JS file with Popper.js
- `bootstrap.min.css.map` | `bootstrap.min.js.map` | `bootstrap.bundle.min.js.map`
  - used to facilitate debugging of minified CSS and JavaScript files
    by mapping the minified code back to the original source code
  - useful in development environments


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

## Mixins

* Bootstrap **CDN**, only provides the **compiled CSS**.
* To use Bootstrap's Sass mixins,
  you need to include the Bootstrap Sass files directly in your project instead of using the CDN.

#### CSS mixins
- used to define styles that can be reused throughout the stylesheet
- keep CSS **DRY** (`Don't Repeat Yourself`)

```scss
@mixin border-radius($radius) {
  ...
}

.button {
  @include border-radius(5px);
  ...
}
```

#### JavaScript Mixins
- used to add properties and methods from one object to another
- useful for sharing behavior between classes without using inheritance


## Other CSS styles related files

`assets/js/`
- `theme.js`: JS script for enabling switching between **_dark_** and **_light_** site color themes/modes
- `copy-to-clipboard.js`: JS script for copying code snippets to the clipboard

`_includes/footer.html`
- web page footer


---

# Markdown Processor
options: `kramdown` | `GFM` | `Markdown` | `HTML`

`kramdown`: https://kramdown.gettalong.org/documentation.html
- default markdown processor for Jekyll
- only kramdown can be locally built with Jekyll

`GFM`: GitHub Flavored Markdown

# Style Code Blocks with Markdown Processor, Clipboard.js, and Bootstrap

syntax highlighters supported by Jekyll: `rouge`, `coderay`

#### Handling Liquid Tags in Code Blocks
If you are using a language that contains curly braces,
* wrap the code block that contains `{%` and `%}` with  
  `{% raw %}` and `{% endraw %}` tags.
* From Jekyll 4.0, 
  * add `render_with_liquid: false` in front matter
    to **disable Liquid entirely** for a particular document

## Syntax Highlighting with `rouge` Syntax Highlighter
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

## Enable color mode changes for syntax highlighting 

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

## Add Copy to Clipboard Button to Code Blocks

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

`_sass/mixins/_border-radius.scss` | `_sass/mixins/_breakpoints.scss`:
- [bootstrap mixins](https://github.com/twbs/bootstrap/tree/main/scss/mixins) required for `copy-to-clipboard.js`

`_sass/_mixins.scss`: import bootstrap mixins

`_sass/_variables.scss`: define variables required for the bootstrap mixins

`assets/css/styles.scss`: import the mixins, variables and clipboard-js styles
```scss
---
---
@import "variables";
@import "mixins";
@import "clipboard-js";
....
```

# Custom Github Actions workflow for building and deploying Jekyll site with custom environment and gem versions

dependencies supported by default github jekyll action: https://pages.github.com/versions/

## Prerequisites
`Gemfile` with correct versions of dependencies

```ruby
# Gemfile

source "https://rubygems.org"

gem "jekyll", "~> 4.4.1"
gem "kramdown-parser-gfm", "~> 1.1.0"
gem "rouge", "~> 4.3.0"
```

## Github Actions Workflow

**starter workflow** for Jekyll sites: https://github.com/actions/starter-workflows/blob/main/pages/jekyll.yml
- triggered on every push to the default branch
- expect Gemfile in the root directory


### Github Action workflows
- [preset reusable actions](https://github.com/actions)
- **[Github Environment Protection Rules](https://docs.github.com/en/actions/managing-workflow-runs-and-deployments/managing-deployments/managing-environments-for-deployment#environment-protection-rules)**:
  limit which branches can deploy to an environment
  - Deployment branches rules
    - All branches can deploy
    - Protected branches (with protection rules) can deploy
    - Selected branches (matching a set of name patterns) can deploy
- **[Github Branch Protection Rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/managing-a-branch-protection-rule#about-branch-protection-rules)**
- workflow file location in repo: `.github/workflows/jekyll.yml`

### Setting up the Action

git repo -> `Settings` -> `Pages` -> `Build and deployment` -> `Source`
- change to `GitHub Actions`

git repo -> `Actions` -> `New workflow` -> search for `Jekyll` ->
- `Configure` under `Jekyll workflow` (**not** _GitHub Pages Jekyll_ workflow )
- Review the changes
  - specially if you are deploying from a subdirectory,
    then **jekyll build command options** and **config file path** should be updated
  - `.github/workflows/jekyll.yml`

- `Commit changes`


### Build and Deploy

git repo -> `Actions` -> `Deployments` -> view live site via deployed site URL


## Workflow Management
`Caching` — The `ruby/setup-ruby` action makes it possible to cache installed gems automatically
instead of having to download the bundle on each build.

# Add Table of Content for `.md` files

Using [allejo/jekyll-toc](https://github.com/allejo/jekyll-toc)
- This template does not allow skipping heading levels in the table of contents.
  - For example, you cannot jump from Heading 2 directly to Heading 5.
- TOC is generated based on <h1> to <h6> headings in the markdown content

`_includes/toc.html`: liquid template for generating TOC
- `https://github.com/allejo/jekyll-toc/blob/master/_includes/toc.html`

`_sass/_toc.scss`: styles for the table of contents
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/site/assets/scss/_toc.scss

`_sass/_layout.scss`: styles for the layout with TOC
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/site/assets/scss/_layout.scss

`_sass/vendor/_rfs.scss`: styles for responsive font sizes
- https://github.com/twbs/bootstrap/blob/90acd33350e1356194a364595cb07b65f24bd611/scss/vendor/_rfs.scss

`_sass/_mixins.scss`: import RFS mixins required for styles
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

usage: in the layout where `{{content}}` is rendered
```html
{% include toc.html html=content h_min=1 h_max=8 item_class="nav-item" anchor_class="nav-link" %}
```
- **html**: the HTML of compiled markdown (generated by kramdown in Jekyll)
- **sanitize**: if true, headers will be stripped of any HTML in the TOC
- **class**: CSS class assigned to the TOC
- **id**: ID to assigned to the TOC
- **h_min**: minimum TOC header level to use
- **h_max**: maximum TOC header level to use
- **ordered**: if true, an ordered list will be outputted instead of an unordered list
- **item_class**: class(es) for each list item `<li></li>`
- **submenu_class** (string): class(es) for each child group of headings
- **base_url**: the base url needed when TOC links content on another page than the actual content
- **anchor_class**: class(es) for each anchor element `<a></a>`
- **skip_no_ids**: if true, skip headers that do not have an `id` attribute
- **flat_toc**: if true, the TOC will be a single level list

# Add Anchors to Headings

Using [Anchor.js](https://www.bryanbraun.com/anchorjs/)

`_includes/scripts.html`: include the anchor.js script
```html
<!-- Anchor.js CDN to add anchor links to headings: https://www.bryanbraun.com/anchorjs/ -->
<script src="https://cdn.jsdelivr.net/npm/anchor-js/anchor.min.js"></script>
<script>
    anchors.add(); <!-- Add anchors before the closing body tag. -->
</script>
```

# Enable Scrollable TOC that automatically highlights the current section

Using `Bootstrap's Scrollspy` component: JS plugin for automatically updating navigation components 
based on scroll position to indicate which link is currently active in the viewport

`_includes/scripts.html`: CDN for Bootstrap's JS file to be included as a script

`_sass/_scrolling.scss`: to prevent focus from landing behind the sticky header, when navigating with the keyboard
- specially useful when using navigation bars that stick to the top

`assets/css/styles.scss`: import the scrolling styles

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
.....
```

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

## SVG Icons

`_includes/svg-icons.html`: include all the SVG icons in a common html file
```html
<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
  <symbol id="clipboard" viewBox="0 0 16 16">
    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"></path>
    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"></path>
  </symbol>
  <symbol>
    ....
  </symbol>
  ...
</svg>
```

`_layouts/default.html`: include the html with SVG icons in the main layout
```html
<!doctype html>
<html lang="en" data-bs-theme="light">
{% include head.html %}
{% include svg-icons.html %}
.....
</html>
```

`<CODE_SNIPPET_WITH_SVG_ICON>.html`: reusing the SVG icon wherever needed
```html
<svg class="bi" role="img" aria-label="Copy"><use xlink:href="#clipboard"/></svg>
```
