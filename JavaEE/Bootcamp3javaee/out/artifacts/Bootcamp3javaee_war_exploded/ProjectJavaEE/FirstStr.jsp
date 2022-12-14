<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="navbar10.jsp"%>
</head>
<body>
<header class="masthead text-center text-pink">
    <div class="masthead-content" style="background-image: url('/img/fddd.jpg')">
        <div class="container px-5">
            <br>
            <br>
            <h1 class="masthead-heading mb-0" style="color: azure"><b>Дорогой, дневник!</b></h1>
<%--            <h2 class="masthead-subheading mb-0" style="color: azure">.</h2>--%>
            <a class="btn btn-warning rounded-pill mt-5" href="/ProjectJavaEE/strAvtor.jsp" style="color: azure">Learn More</a>
        </div>
    </div>
    <div class="bg-circle-1 bg-circle"></div>
    <div class="bg-circle-2 bg-circle"></div>
    <div class="bg-circle-3 bg-circle"></div>
    <div class="bg-circle-4 bg-circle"></div>
</header>
<!-- Content section 1-->
<section id="scroll">
    <div class="container px-5">
        <div class="row gx-5 align-items-center">
            <div class="col-lg-6 order-lg-2">
                <div class="p-5"><img class="img-fluid rounded-circle" src="/img/1.jpeg" alt="..." /></div>
            </div>
            <div class="col-lg-6 order-lg-1">
                <div class="p-5">
                    <h2 class="display-4">Моя история</h2>
                    <p>В нашей жизни происходит множество удивительных ситуаций, предугадать исход которых бывает совершенно невозможно.
                        Порой некоторые вещи случаются, словно по волшебству, когда мы сильного этого хотим... </p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Content section 2-->
<section>
    <div class="container px-5">
        <div class="row gx-5 align-items-center">
            <div class="col-lg-6">
                <div class="p-5"><img class="img-fluid rounded-circle" src="/img/2.jpeg" alt="..." /></div>
            </div>
            <div class="col-lg-6">
                <div class="p-5">
                    <h2 class="display-4">Семья и близкие</h2>
                    <p>Семья является важнейшим элементом формирования счастья каждого человека...
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Content section 3-->
<section>
    <div class="container px-5">
        <div class="row gx-5 align-items-center">
            <div class="col-lg-6 order-lg-2">
                <div class="p-5"><img class="img-fluid rounded-circle" src="/img/WhatsApp%20Image%202022-12-07%20at%2016.09.19.jpeg" alt="..." /></div>
            </div>
            <div class="col-lg-6 order-lg-1">
                <div class="p-5">
                    <h2 class="display-4">Спорт-моя жизнь!</h2>
                    <p> Спорт воспитывает характер человека. Занятие спортом укрепляет силу воли, дисциплинирует людей...
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-black">
    <div class="container px-5"><p class="m-0 text-center text-white small">Copyright &copy; My Website 2022</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
