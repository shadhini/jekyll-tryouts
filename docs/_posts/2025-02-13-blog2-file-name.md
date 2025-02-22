---
layout: post
author: jack
title: Blog2 Title
render_with_liquid: false
---

#### Blog 2: With Code Snippets 

This is an example of a blog post.

here is a single back tick snippet: `single backtick`

```markdown
<!-- Markdown Code Snippet -->
# Markdown Code Snippet
This is a code snippet.
```


```html
<!-- HTML Code Snippet -->
<nav>
    <a href="/" {% if page.url == "/" %}style="color: red;"{% endif %}>
    Home
    </a>
    <a href="/about.html" {% if page.url == "/about.html" %}style="color: red;"{% endif %}>
    About
    </a>
</nav>
```
