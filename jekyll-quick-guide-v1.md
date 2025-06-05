# Jekyll Tryouts: Quick Reference Guide

## Testing Jekyll on GH Pages locally with live reload

from the root directory for gh pages
```bash
cd docs
bundle exec jekyll serve --livereload
```

# Directory Structure

```text
.
├── docs: root gh pages publishing directory
│         ├── Gemfile: gem dependencies
│         ├── Gemfile.lock: gem dependencies lock file --> excluded from remote repo
│         ├── _config.yml: configuration file
│         ├── _plugins
│         │         └── nodateposts.rb: custom plugin to allow posts without dates
│         ├── _data: data files
│         │         │       * site.data
│         │         ├── navigation.yml: navigation data
│         │         │       * site.data.navigation
│         │         ├── sidebar.yml: sidebar groups and items
│         │         │       * site.data.sidebar
│         │         ├── technologies.yml: technologies list with related topics & similar technologies
│         │         │       * site.data.technologies
│         │         └── topics.yml: topics list with related technologies & related topics
│         │                 * site.data.topics
│         ├── _includes: reusable code snippets
│         │         ├── docs-sidebar.html: sidebar for documentation
│         │         ├── footer.html: footer for the site
│         │         ├── head.html: head section of the site (stylesheets, scripts, meta tags)
│         │         ├── navigation.html: navigation bar for the site
│         │         ├── scripts.html: JS scripts list
│         │         ├── stylesheet.html: stylesheet list
│         │         ├── svg-icons.html: SVG icons list
│         │         ├── technologies-breadcrumbs.html: breadcrumbs for pages/docs related to technologies 
│         │         │       * not used
│         │         ├── technology-list-accordion.html: accordion list of all technologies & their metadata
│         │         ├── technology-metadata.html: technology metadata for current technology page
│         │         ├── topic-list-accordion.html: accordion list of all topics & their metadata
│         │         ├── topic-metadata.html: topic metadata for current topic page
│         │         ├── theme-toggler.html: theme/color mode toggler
│         │         └── toc.html: TOC generator for markdown files
│         │                 * only markdown content is correctly processed
│         │                 * skipping/jumping heading levels distort output
│         ├── _layouts: page layouts
│         │         ├── base.html: base layout and structure
│         │         ├── default.html: default layout 
│         │         │       * single column - inherits from base
│         │         ├── doc.html: 3 column layout for documentation with switchable & scrollable sidebar and toc 
│         │         │       * inherits from base
│         │         ├── landing-page.html: landing page layout with cover image 
│         │         │       * inherits from base
│         │         ├── technology.html
│         │         │       * inherits from doc
│         │         ├── topic.html
│         │         │       * inherits from doc
│         │         ├── post.html: layout for blog posts
│         │         │       * inherits from doc
│         │         └── author.html
│         │                 * inherits from doc
│         ├── _sass: sass styling files
│         │         ├── _clipboard-js.scss: styling for clipboard.js
│         │         ├── _custom.scss: custom project styles
│         │         ├── _layout.scss: layout styles
│         │         ├── _scrolling.scss: styles for preventing focus from landing behind the sticky header
│         │         │         when navigating with the keyboard
│         │         ├── _sidebar.scss: sidebar styles
│         │         ├── _syntax-highlighting.scss: syntax highlighting styles based on color mode 
│         │         │       * derived from rouge pygments styles
│         │         ├── _toc.scss: TOC styles
│         │         ├── _variables.scss: project variables; 
│         │         │       * includes _variables.scss from bootswatch theme & other required variables
│         │         ├── _mixins.scss: mixins required for styles
│         │         ├── mixins
│         │         │         ├── _border-radius.scss: required for layout styles
│         │         │         ├── _breakpoints.scss: required for layout styles
│         │         │         └── _color-mode.scss: required for color mode changes
│         │         └── vendor: vendor styles
│         │             └── _rfs.scss: responsive font sizes from bootstrap side project
│         ├── assets: site assets
│         │         ├── css
│         │         │         └── styles.scss: entry point for the website’s CSS
│         │         │               * all other stylesheets(.scss files) are imported here
│         │         ├── images
│         │         │         └── landing-page-cover-image.png
│         │         └── js
│         │             ├── copy-to-clipboard.js: script for copying code snippets to the clipboard
│         │             └── theme.js: script for enabling switching between dark and light site color themes/modes
│         ├── _posts: blog posts
│         │         │       * site.posts: posts list
│         │         │       * post.url
│         │         │       * post.title: post filename or front matter title
│         │         │       * post.excerpt: first para of content
│         │         ├── 2025-02-10-blog1-file-name.md
│         │         ├── 2025-02-13-blog2-file-name.md
│         │         └── 2025-02-15-jekyll-guide.md
│         ├── _authors
│         │         └── jill.md
│         ├── _<COLLECTION_NAME>: sample collection; there can be any number of collections
│         │         │       * site.collections: collections list
│         │         │       * site.documents: documents list of all collections
│         │         │       * site.<COLLECTION_NAME>
│         │         └── <COLLECTION_ITEM>.md: sample collection item
│         ├── _technologies
│         │         ├── bootstrap.md
│         │         ├── jekyll.md
│         │         └── tailwind-css.md
│         ├── technologies
│         │         └── bootstrap: sample extra/important notes on bootstrap
│         │             ├── commands
│         │             │         └── bootstrap-commands.md
│         │             └── test-frameworks
│         │                 ├── bootstrap-framework-2.md
│         │                 └── bootstrap-framweok-1.md
│         ├── _topics
│         │         ├── css-frameworks.md
│         │         └── web-development-technologies.md
│         ├── about.md
│         ├── authors.md
│         ├── blogs.md: blogs (taken from /_posts) list view
│         ├── tech-catalog.md: tabular technology and topic catalog
│         ├── technologies.md: technology list
│         ├── topics.md: topic list
│         ├── index.md: home page
│         ├── 404.html: cutom 404 page
│         └──_site: generated site files
├── LICENSE
└── README.md

```


# Reusable Templates

## Ruby plugin to allow posts without dates
```text
.
└── docs: root gh pages publishing directory
      └── _plugins
              └── nodateposts.rb: custom plugin to allow posts without dates
```

## Base Layout
```text
.
└── docs: root gh pages publishing directory
         ├── _layouts: page layouts
         │        └── base.html: base layout and structure
         └── _includes: reusable code snippets
                  ├── footer.html: footer for the site
                  ├── head.html: head section of the site (stylesheets, scripts, meta tags)
                  ├── navigation.html: navigation bar for the site
                  ├── scripts.html: JS scripts list
                  ├── stylesheet.html: stylesheet list
                  └── svg-icons.html: SVG icons list
```

## Navigation Menu Bar
```text
.
└── docs: root gh pages publishing directory
         ├── _data: data files
         │         │       * site.data
         │         └── navigation.yml: navigation data
         │                 * site.data.navigation
         └── _includes: reusable code snippets
                   └── navigation.html: navigation bar for the site
```

## Theme/ Color Mode Toggling
```text
.
└── docs: root gh pages publishing directory
         ├── _includes: reusable code snippets
         │         ├── theme-toggler.html: theme/color mode toggler
         │         └── navigation.html: navigation bar for the site
         └── assets: site assets
                   └── js
                      └── theme.js: script for enabling switching between dark and light site color themes/modes
```

## Syntax Styling for Code Blocks
```text
.
└── docs: root gh pages publishing directory
         ├── _sass: sass styling files
         │         ├── _custom.scss: custom project styles
         │         ├── _syntax-highlighting.scss: syntax highlighting styles based on color mode 
         │         │       * derived from rouge pygments styles
         │         ├── _variables.scss: project variables; 
         │         │       * includes _variables.scss from bootswatch theme & other required variables
         │         ├── _mixins.scss: mixins required for styles
         │         └── mixins
         │                   └── _color-mode.scss: required for color mode changes
         ├── assets: site assets
         │         └── css
         │                   └── styles.scss: entry point for the website’s CSS
         │                         * all other stylesheets(.scss files) are imported here
         └── _config.yml: kramdown syntax highlighting configurations
```

## Copy to Clipboard button for code blocks
```text
.
└── docs: root gh pages publishing directory
         ├── _sass: sass styling files
         │         ├── _clipboard-js.scss: styling for clipboard.js
         │         ├── _custom.scss: custom project styles
         │         └── _variables.scss: project variables; 
         │                * includes _variables.scss from bootswatch theme & other required variables
         └── assets: site assets
                  ├── css
                  │         └── styles.scss: entry point for the website’s CSS
                  │               * all other stylesheets(.scss files) are imported here
                  └── js
                      └── copy-to-clipboard.js: script for copying code snippets to the clipboard
```

## Liquid & HTML 3 Column Page Template with Sidebar & TOC
```text
.
└── docs: root gh pages publishing directory
         ├── _data: data files
         │         │       * site.data
         │         └── sidebar.yml: sidebar groups and items
         │                 * site.data.sidebar
         ├── _includes: reusable code snippets
         │         ├── docs-sidebar.html: sidebar for documentation
         │         └── toc.html: TOC generator for markdown files
         │                 * only markdown content is correctly processed
         │                 * skipping/jumping heading levels distort output
         ├── _layouts: page layouts
         │         └── doc.html: 3 column layout for documentation with switchable & scrollable sidebar and toc 
         │                 * inherits from base
         ├── _sass: sass styling files
         │         ├── _custom.scss: custom project styles
         │         ├── _layout.scss: layout styles
         │         ├── _sidebar.scss: sidebar styles
         │         ├── _toc.scss: TOC styles
         │         ├── _scrolling.scss: styles for preventing focus from landing behind the sticky header
         │         │         when navigating with the keyboard
         │         ├── _mixins.scss: mixins required for styles
         │         ├── _variables.scss: project variables; 
         │         │       * includes _variables.scss from bootswatch theme & other required variables
         │         ├── mixins
         │         │         ├── _border-radius.scss: required for layout styles
         │         │         └── _breakpoints.scss: required for layout styles
         │         └── vendor: vendor styles
         │             └── _rfs.scss: responsive font sizes from bootstrap side project
         └── assets: site assets
                   └── css
                             └── styles.scss: entry point for the website’s CSS
                                   * all other stylesheets(.scss files) are imported here
```

## Sample Collection
```text
.
└── docs: root gh pages publishing directory
         ├── _includes: reusable code snippets
         │         ├── technologies-breadcrumbs.html: breadcrumbs for pages/docs related to `technologies` collection 
         │         └── technology-list-accordion.html: accordion list of all documents in `technologies` collection
         ├── _layouts: page layouts
         │         └── technology.html: layout for documents in technology collection
         ├── _technologies: sample collection; there can be any number of collections
         │         │       * site.collections: collections list
         │         │       * site.documents: documents list of all collections
         │         │       * site.technologies
         │         └── jekyll.md: sample collection item     
         ├── technologies.md: list view of documents in the technology collection  
         └── _config.yml: `technologies` collection configurations
  

```

## Blogging
```text
.
└── docs: root gh pages publishing directory
         ├── _layouts: page layouts
         │         ├── post.html: layout for blog posts
         │         │       * inherits from doc
         │         └── author.html: layout for authors
         │                 * inherits from doc
         ├── _posts: blog posts
         │         │       * site.posts: posts list
         │         │       * post.url
         │         │       * post.title: post filename or front matter title
         │         │       * post.excerpt: first para of content
         │         ├── 2025-02-10-blog1-file-name.md
         │         └── 2025-02-15-jekyll-guide.md
         ├── _authors
         │         └── jill.md
         ├── authors.md: list of authors 
         └── blogs.md: blogs (taken from /_posts) list view
```

## Custom 404 Not Found Page
```text
.
└── docs: root gh pages publishing directory
         └── 404.html: cutom 404 page
```

## Technology Catalog
main page: `tech-catlog.md`
lists:
- `technologies.md`
- `topics.md`

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

`_includes`
- `technology-metadata.html`: metadata for current technology page
- `topic-metadata.html`: metadata for current topic page
- `technology-list-accordion.html`: accordion list of all technologies & their metadata
- `topic-list-accordion.html`: accordion list of all topics & their metadata

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
