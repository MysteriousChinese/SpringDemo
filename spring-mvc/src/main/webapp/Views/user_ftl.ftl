<!DOCTYPE HTML>
<html>
  <head>
      <title>freemarke模板</title>
  </head>
  <body>
     List:<br/>
  <#list list as item>
      <p style="color: red">${item}</p>
  </#list>
  User:<br/>
  ${user.id} -- > ${user.name}
  </body>
</html>