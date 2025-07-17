import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';



function Header() {
    return (
        <>
            <div className="container">
                <header className="py-4 col-md-auto ">
                
                    <nav class="navbar navbar-expand-lg bg-body-tertiary">
                        <div class="container-fluid">
                            <a className="navbar-brand" href="#">Blog Pedro Garcia</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Blog</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            Meus Projetos
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a className="dropdown-item" href="#">GithHub</a></li>
                                            <li><a className="dropdown-item" href="#">TikTok</a></li>
                                            <li><a className="dropdown-item" href="#">Youtube Gameplays</a></li>
                                            <li><a className="dropdown-item" href="#">Youtube Pessoal</a></li>
                                            <li><a className="dropdown-item" href="#">Twitch</a></li>
                                        </ul>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            Contato
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a className="dropdown-item" href="#">Linkedin</a></li>
                                            <li><a className="dropdown-item" href="#">Instagram</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <form class="d-flex" role="search">
                                    <input class="form-control me-2" type="search" placeholder="Pesquisar" aria-label="Search" />
                                    <button class="btn btn-outline-success" type="submit">Pesquisar</button>
                                </form>
                            </div>
                        </div>
                    </nav>
                </header>

            </div>

        </>
    );
}

export default Header;