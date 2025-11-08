const fs = require('fs');
const path = require('path');

// --- Define your paths here ---
// Example: Copying a _redirects file into the build output
const sourceFile = 'build/index.html';
const destFile = 'build/404.html'; 
// ------------------------------

console.log(`Starting post-build: Copying ${sourceFile} to ${destFile}...`);

try {
  // Resolve paths to be absolute
  const sourcePath = path.resolve(__dirname, '..', sourceFile);
  const destPath = path.resolve(__dirname, '..', destFile);

  // Ensure the destination directory exists
  const destDir = path.dirname(destPath);
  if (!fs.existsSync(destDir)) {
    fs.mkdirSync(destDir, { recursive: true });
    console.log(`Created directory: ${destDir}`);
  }

  // Copy the file
  fs.copyFileSync(sourcePath, destFile);
  
  console.log('✅ File copied successfully!');

} catch (err) {
  console.error('Error copying file:', err);
  process.exit(1); // Exit with an error code to fail the build
}