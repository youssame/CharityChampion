import '@/styles/globals.css';
import NavBar from '@/components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@/styles/custom-navbar.css';
function App({ Component, pageProps }) {
  return (
      <div>
          <NavBar />
          <Component {...pageProps} />
      </div>
  );
}
export default App;
