var gulp = require('gulp');

gulp.task('default', function () {
    return gulp.src('templates/**/*.html')
        .pipe(gulp.dest('../../../build/resources/main/templates'));
});

gulp.task('lib:js', function () {
    return gulp.src('bower_components/**/*.js')
        .pipe(gulp.dest('static/scripts/lib'))
        .pipe(gulp.dest('../../../build/resources/main/static/scripts/lib'));
});

gulp.task('lib:css', function () {
    return gulp.src('bower_components/**/*.css')
        .pipe(gulp.dest('static/scripts/lib'))
        .pipe(gulp.dest('../../../build/resources/main/static/scripts/lib'));
});

gulp.task('static', function () {
    return gulp.src('static/**/*')
        .pipe(gulp.dest('../../../build/resources/main/static'));
});

gulp.task('watch', function () {
    gulp.watch('templates/**/*.html', ['default']);
    gulp.watch('static/**/*', ['static']);
});