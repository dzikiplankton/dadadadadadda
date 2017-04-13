<%@ page import="pzak.Creature" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="mine"/>
    <title>Creatures</title>
    <asset:link rel="icon" href="favicon.png" type="image/x-ico"/>

</head>

<body >
<div class="clouds-1">
<div class="well container" style="margin: 0 auto; width: 80%; background: transparent">
    <p class="text-success" style="margin-top: 40px">There are ${Creature.count()} creatures in the database.</p>

    <ul  >
        <g:each in="${Creature.list()}" var="cr">
            <div class="creature img-thumbnail">
            <div class="container-fluid  text-center clouds-2 ">
                <h3 class="margin">Who am I ?</h3>
                <img src="${cr.link}" class="img-responsive img-circle margin" style="display:inline"
                     alt="${cr.name}">

                <h3>I'm an ${cr.name}</h3>
            </div>

            <div class="container-fluid blue text-center">
                <h3 class="margin">What Am I?</h3>

                <p>

                <p>${cr.description}</p>
                <a href="https://www.google.pl/#q=${cr.name}&*" class="btn btn-sucess btn-lg">
                    <span class="glyphicon glyphicon-search"></span> Search on web
                </a>
            </div>
            </div>

            <div class="container-fluid bg-1 text-center">

            </div>
        </g:each>
    </ul>
</div>
</div>
</body>

</html>
