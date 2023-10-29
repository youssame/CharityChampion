import React from 'react';
const Signup = () => {
    return (
            <div className="container mt-5">
                <div className="row justify-content-center border-around" style={{border:'1px solid black'}}>
                    <div className="col-md-6">
                        <img
                            src="/CharityChampionSignIn.png"
                            alt="Charity Champion slogon"
                            className="img-fluid"
                            style={{ width: '510px', height: 'auto'}}
                        />
                    </div>
                    <div className="col-md-6">
                        <form>
                            <div className="d-flex align-items-center mb-3 pb-1 justify-content-center">
                                <span className="h1 fw-bold mb-0 justify-content-center" style={{fontFamily:'montserrat'}}>Welcome back Champion</span>
                            </div>
                            <h5 className="fw-normal mb-3 pb-3">Sign into your account</h5>
                            <div className="form-outline mb-4">
                                <label className="form-label" >Username</label>
                                <input type="text"  placeholder="username" className="form-control form-control-lg" />
                            </div>

                            <div className="form-outline mb-4">
                                <label className="form-label">Password</label>
                                <input type="password" placeholder="password" className="form-control form-control-lg" />
                            </div>

                            <div className="pt-1 mb-12 d-flex justify-content-center align-items-center">
                                <button className="btn btn-dark btn-lg btn-block" type="button" style={{ backgroundColor: 'green', fontSize: '20px', width:'50%', marginleft:'200px' }}>Login</button>

                            </div>
                        </form>

                    </div>
                </div>
            </div>
    );
};

export default Signup;
