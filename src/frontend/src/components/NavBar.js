import Link from 'next/link';

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg">
            <Link href="/Signup" legacyBehavior>
                <a className="navbar-brand" style={{ marginleft: '50vw', marginRight: '800px' }}>Charity Champion</a>
            </Link>
            <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <Link href="/Home" legacyBehavior>
                            <a className="nav-link">Home</a>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link href="/Projects" legacyBehavior>
                            <a className="nav-link">Projects</a>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link href="/Donate" legacyBehavior>
                            <a className="nav-link">Donate</a>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link href="/Signup" legacyBehavior>
                            <a className="nav-link">Sign in</a>
                        </Link>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default Navbar;
