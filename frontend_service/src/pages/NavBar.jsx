import React from 'react'

function LandingPage() {

    return (
        <div>
            <nav>
                <div>

                    <ul className="nav bg-dark ">
                        <li className="nav-item">
                            <a className="nav-link text-light" href="ClientInterfacePage">ClientInterfacePage</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link text-light" href="AdminInterfacePage">AdminInterfacePage</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="LoginPage">Sign in/up </a>
                        </li>
                        <li>
                            <text>Microservice app</text>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    )
}

export default LandingPage