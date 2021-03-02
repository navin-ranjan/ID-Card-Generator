/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global fetch, fontkit, PDFLib, userName, use */

const scholar = document.getElementById("scholar");
const uname = document.getElementById("name");
const fname = document.getElementById("fname");
const gender = document.getElementById("gender");
const dob = document.getElementById("dob");
const course = document.getElementById("course");
const session = document.getElementById("session");
const mobile = document.getElementById("mobile");
const address = document.getElementById("address");
const email = document.getElementById("email");
const submitBtn = document.getElementById("submitBtn");

const { PDFDocument, rgb, degrees } = PDFLib;


const capitalize = (str, lower = false) =>
  (lower ? str.toLowerCase() : str).replace(/(?:^|\s|["'([{])+\S/g, (match) =>
    match.toUpperCase()
  );

submitBtn.addEventListener("click", () => {
  const val10 = capitalize(scholar.value);
  const val1 = capitalize(uname.value);
  const val3 = capitalize(fname.value);
  const val4 = capitalize(gender.value);
  const val45 = capitalize(dob.value);
  const val5 = capitalize(course.value);
  const val6 = capitalize(session.value);
  const val7 = capitalize(mobile.value);
  const val8 = capitalize(address.value);
  const val9 = email.value;
  window.alert("Submit Sucessfully");
  //check if the text is empty or not
generatePDF(val10,val1,val3,val4,val45,val5,val6,val7,val8,val9);
  
});

const generatePDF = async (scholar,name,fname,gender,dob,course,session,mobile,address,email) => {
  const existingPdfBytes = await fetch("./idcard.pdf").then((res) =>
    res.arrayBuffer()
  );

  // Load a PDFDocument from the existing PDF bytes
  const pdfDoc = await PDFDocument.load(existingPdfBytes);
  pdfDoc.registerFontkit(fontkit);

  //get font
  const fontBytes = await fetch("./BOOKOS.TTF").then((res) =>
    res.arrayBuffer()
  );

  // Embed our custom font in the document
  const SanChezFont = await pdfDoc.embedFont(fontBytes);

  // Get the first page of the document
  const pages = pdfDoc.getPages();
  const firstPage = pages[0];

  // Draw a string of text diagonally across the first page
 firstPage.drawText(scholar, {
    x:365,
    y:810,
    size: 28,
    font: SanChezFont,
    color: rgb(1, 1,1)
  });
  firstPage.drawText(name, {
    x:240,
    y:720,
    size: 55,
    font: SanChezFont,
    color: rgb(0, 0.53, 0.71)
  });

  firstPage.drawText(fname, {
    x: 490,
    y: 658,
    size: 32,
    font: SanChezFont,
    color: rgb(0.12, 0.12, 0.12)
  });
  firstPage.drawText(gender, {
    x:380,
    y:608,
    size: 32,
    font: SanChezFont,
    color: rgb(0.10, 0.10,0.12)
  });

  firstPage.drawText(dob, {
    x:465,
    y:558,
    size: 30,
    font: SanChezFont,
    color: rgb(0.10, 0.10,0.12)
  });

  firstPage.drawText(course, {
    x:380,
    y:502,
    size: 30,
    font: SanChezFont,
    color: rgb(0.12, 0.12,0.12)
  });
  firstPage.drawText(session, {
    x:388,
    y:450,
    size: 30,
    font: SanChezFont,
    color: rgb(0.12, 0.12,0.12)
  });
  firstPage.drawText(mobile, {
    x:430,
    y:398,
    size: 28,
    font: SanChezFont,
    color: rgb(0.12, 0.12,0.12)
  });

  firstPage.drawText(address, {
    x:395,
    y:290,
    size: 30,
    font: SanChezFont,
    color: rgb(0.12, 0.12,0.12)
  });

  firstPage.drawText(email, {
    x:360,
    y:348,
    size: 30,
    font: SanChezFont,
    color: rgb(0.12, 0.12,0.12)
  });


  // Serialize the PDFDocument to bytes (a Uint8Array)
  const pdfBytes = await pdfDoc.save();
  console.log("Done creating");

  // this was for creating uri and showing in iframe

  // const pdfDataUri = await pdfDoc.saveAsBase64({ dataUri: true });
  // document.getElementById("pdf").src = pdfDataUri;

  var file = new File(
    [pdfBytes],
    "idcard.pdf",
    {
      type: "application/pdf;charset=utf-8"
    }
  );
 saveAs(file);
};

// init();
