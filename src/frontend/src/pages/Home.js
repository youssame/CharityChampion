import React from 'react';
const Home = () => {
    return (
        <div className="container mt-4" style={{ maxWidth: '100%' }}>
            <div className="row" >
                <div className="col-md-6">
                    <h1 className="H1-Slogon" style={{ fontFamily:'montserrat' , marginTop:'80px', marginLeft:'170px'}}> Be a Charity Contributor</h1>
                    <h1 className="H1-Slogon" style={{ fontFamily:'montserrat', marginLeft:'170px' }}>Be a Charity Champion</h1>
                </div>
                <div className="col-md-6">
                    <img
                        src="/pic2.png"
                        alt="Charity Champion slogon"
                        className="img-fluid"
                        style={{ width: '600px', height: 'auto'}}
                    />
                </div>
            </div>

            <div className="row" >
                <div className="col-md-6">
                    <img
                        src="/team.png"
                        alt="Charity Champion team"
                        className="img-fluid"
                        style={{ width: '600px', height: 'auto', marginLeft:'75px'}}
                    />
                </div>

                <div className="col-md-6 justify-content-center">
                    <h2 className="About-us"  style = {{fontFamily:'montserrat',textAlign: 'justify', marginTop:'10px', marginLeft:'30px'}}>About us</h2>
                    <p className="about-us-description" style = {{fontFamily:'montserrat',lineHeight: '2', marginRight:'50px', textAlign: 'justify',  marginLeft:'30px'}}>Welcome to CharityChampion, where we are a dedicated team of three individuals committed to leveraging technology for the greater good. Our mission is clear: to address pressing societal issues and create a positive impact in the lives of those in need. With backgrounds in technology, business, and social entrepreneurship, we have joined forces to build a platform that empowers individuals, organizations, and communities to make a difference. Through CharityChampion, we aim to connect those with a heart for change to worthy causes, bridging the gap between compassion and action. Join us in this transformative journey, as we work together to leave a lasting, positive impact on countless lives and champion the spirit of giving.</p>
                </div>
            </div>

            <div className="row"  style={{ marginLeft:'60px', marginRight:'40px'}}>
                <h2 className="Open-Projects"  style = {{fontFamily:'montserrat',textAlign: 'justify'}}>Open Projects</h2>
                <div className="col-md-4">
                    <img
                        src="/pic2.png"
                        alt="Charity Champion team"
                        className="img-fluid"
                        style={{ width: '400px', height: '250px'}}
                    />
                    <p>Donate for this mosque, it is located in tangier. and it will benefit mora than 100000 person per day.</p>
                    <button className="btn btn-primary justify-content-center" style={{marginLeft:'120px'}}>Learn More</button>
                </div>

                <div className="col-md-4">
                    <img
                        src="/pic1.jpg"
                        alt="Charity Champion team"
                        className="img-fluid"
                        style={{ width: '400px', height: '250px'}}
                    />
                    <p>Donate for this mosque, it is located in tangier. and it will benefit mora than 100000 person per day.</p>
                    <button className="btn btn-primary justify-content-center" style={{marginLeft:'120px'}}>Learn More</button>

                </div>

                <div className="col-md-4">
                    <img
                        src="/team.png"
                        alt="Charity Champion team"
                        className="img-fluid"
                        style={{ width: '400px', height: '250px'}}
                    />
                    <p>Donate for this mosque, it is located in tangier. and it will benefit mora than 100000 person per day.</p>
                    <button className="btn btn-primary justify-content-center" style={{marginLeft:'120px'}}>Learn More</button>

                </div>
            </div>

        </div>
    );
};

export default Home;
