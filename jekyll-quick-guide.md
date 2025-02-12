#### Testing Jekyll on GH Pages locally with live reload
from the root directory for ph pages
```bash
jekyll serve --livereload
```

#### Configuration
`_config.yml`
```yaml
# Base URL: if your site is hosted at https://username.github.io/repository-name
baseurl: "/jekyll-tryouts"
```

#### Directory Structure

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
    |-- assets: site assets
        |-- css
        |-- js
        |-- images
    |-- index.html/index.md
    |-- about.html/about.md
    |-- contact.html/contact.md
    |-- blogs.html: blogs (taken from /_posts) list view 
```

#### Site Assets & Styling
assets location: `assets`
- `assets/css/style.scss`
    ```scss
    ---
    ---
    @import "main";
     ```
- `assets/js/`
- `assets/images/`

sass location: `_sass/`
- `_sass/main.scss`

assets runtime location: `_site/assets/`

stylesheet url: `assets/css/style.css`

```html
<!doctype html>
<html>
<head>
    .....
    <link rel="stylesheet" href="assets/css/styles.css"> <!-- link to the style sheet -->
</head>
.....
</html>
```

#### Navigation
`_includes/navigation.html`
      
-     site.data.navigation

data file: `_data/navigation.yml`
```yaml
- name: Home
  link: /
- name: About
  link: /about.html
```

#### Layouts
can inherit from another layout
