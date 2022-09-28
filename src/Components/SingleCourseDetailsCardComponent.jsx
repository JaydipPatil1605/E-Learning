import React, { Component } from "react";
import CourseService from "../Services/CourseService";

class SingleCourseDetailsCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      courseDetails: "",
      userStatus: "",
    };
  }
  state = {

    // Initially, no file is selected
    selectedFile: null
  };
  onFileChange = event => {

    // Update the state
    this.setState({ selectedFile: event.target.files[0] });

  };
  onFileUpload = event => {

    // upload the state
    alert("File Uploded Successfully....!");
    this.setState({ selectedFile: event.target.files[0] });

  };

  onFileDownload = event => {

    // Download the file
    alert("File Downloaded Successfully....!")
    this.setState({ selectedFile: event.target.files[0] });

  };
  componentDidMount() {

    if (this.props.userStatus === "student") {
      CourseService.getCourseDetailByStudentId(this.props.data1).then(
        (response) => {
          this.setState({ courseDetails: response.data });
        }
      );
    }
    if (this.props.userStatus === "mentor") {
      CourseService.getCourseDetailByMentorId(this.props.data1).then(
        (response) => {
          this.setState({ courseDetails: response.data });
        }
      );
    }
  }

  render() {
    return (
      <div className="container">
        <div className="greetingsProfileCard">
          <center className="greetingsProfileInfo">
            <p style={{ fontSize: "20px" }}>
              Hello &nbsp;
              {this.props.data2},
              your course details are as follows
            </p>
          </center>
        </div>
        <div className="card text-white bg-dark mb-3 coursedetailcard">
          <div className="card-body">
            <p className="card-text">
              Course Name :- {this.state.courseDetails.courseName}{" "}
            </p>
            <p className="card-text">
              Course Id :- {this.state.courseDetails.courseId}{" "}
            </p>
            <p className="card-text">
              Start Date :- {this.state.courseDetails.startDate}{" "}
            </p>
            <p className="card-text">
              End Date :- {this.state.courseDetails.endDate}{" "}
            </p>
            <p>
              {/* {this.state.userStatus === 'mentor'?<div><button className="btn btn-primary">uploadLink</button></div> : <div>ViewLink</div>} */this.state.userStatus}
              End Date :- {this.state.userStatus}{" "}
            </p>
            <p>
            {this.props.userStatus === 'mentor'?<div><div>
                <input type="file" onChange={this.onFileChange} />
                <br/>
                <p><a href="mailto: ''">Send Email</a></p>
                <button onClick={this.onFileUpload}>
                  Upload!
                </button>
              </div></div>:<div>
                <button onClick={this.onFileDownload}>download</button>
                <br/>
                <a href="https://www.youtube.com/watch?v=cW3CRbdjedQ&t=119s">Watch Video</a>
                </div>}
            </p>
          </div>
        </div>
      </div>
    );
  }
}

export default SingleCourseDetailsCard;
