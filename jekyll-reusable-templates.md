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

